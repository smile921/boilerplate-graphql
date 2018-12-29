package org.smile921.graphql.rest;

import java.io.File;

import javax.management.Query;
import javax.servlet.annotation.WebServlet;

import org.smile921.graphql.repo.HumanRepository;

import graphql.schema.GraphQLSchema;
import graphql.schema.StaticDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

	GraphQLEndpoint() {
		super(buildSchema());
	}

	private static GraphQLSchema buildSchema() { 
		SchemaParser parser = new SchemaParser();
		File file = new File("schema.graphqls");
		TypeDefinitionRegistry registry = parser.parse(file);

		RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring()
				.type("Query", builder -> builder.dataFetcher("hello", new StaticDataFetcher("world"))).build();
		SchemaGenerator schemaGenerator = new SchemaGenerator();
		GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(registry, runtimeWiring);
		return graphQLSchema;
	}

}
