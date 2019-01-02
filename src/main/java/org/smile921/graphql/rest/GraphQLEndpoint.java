package org.smile921.graphql.rest;

import java.io.File;

import javax.management.Query;
import javax.servlet.annotation.WebServlet;
 
import org.smile921.graphql.repo.HumanRepository;

import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;
import graphql.schema.GraphQLSchema;
import graphql.schema.StaticDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry; 

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint {

	GraphQLEndpoint() { 
	}
 
	private  GraphQLSchema buildSchema() { 
		SchemaParser parser = new SchemaParser();
				File file = new File("schema.graphqls");
		TypeDefinitionRegistry registry = parser.parse(file);

		RuntimeWiring runtimeWiring = buildRuntimeWiring();
		SchemaGenerator schemaGenerator = new SchemaGenerator();
		GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(registry, runtimeWiring);
		return graphQLSchema;
	}

	private RuntimeWiring buildRuntimeWiring() {
		// TODO Auto-generated method stub
		return null;
	}
	 

}
