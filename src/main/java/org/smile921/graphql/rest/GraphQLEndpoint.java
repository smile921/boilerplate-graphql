package org.smile921.graphql.rest;

import java.io.File;

import javax.management.Query;
import javax.servlet.annotation.WebServlet;

import org.smile921.graphql.po.StarWarsData;
import org.smile921.graphql.repo.HumanRepository;

import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;
import graphql.schema.GraphQLSchema;
import graphql.schema.StaticDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.schema.idl.TypeRuntimeWiring;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

	GraphQLEndpoint() {
		super(buildSchema());
	}

	private static GraphQLSchema buildSchema1() { 
		SchemaParser parser = new SchemaParser();
		File file = new File("schema.graphqls");
		TypeDefinitionRegistry registry = parser.parse(file);

		RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring()
				.type("Query", builder -> builder.dataFetcher("hello", new StaticDataFetcher("world"))).build();
		SchemaGenerator schemaGenerator = new SchemaGenerator();
		GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(registry, runtimeWiring);
		return graphQLSchema;
	}
	
	private static GraphQLSchema buildSchema() { 
		SchemaParser parser = new SchemaParser();
				File file = new File("schema.graphqls");
		TypeDefinitionRegistry registry = parser.parse(file);

		RuntimeWiring runtimeWiring = buildRuntimeWiring();
		SchemaGenerator schemaGenerator = new SchemaGenerator();
		GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(registry, runtimeWiring);
		return graphQLSchema;
	}
	
	public static  RuntimeWiring buildRuntimeWiring() {
	        GraphQLScalarType scalar =  null;
			return RuntimeWiring.newRuntimeWiring()
	                .scalar(scalar )
	                // this uses builder function lambda syntax
	                .type("QueryType", typeWiring -> typeWiring
	                        .dataFetcher("hero", new StaticDataFetcher(StarWarsData.getArtoo()))
	                        .dataFetcher("human", StarWarsData.getHumanDataFetcher())
	                        .dataFetcher("droid", StarWarsData.getDroidDataFetcher())
	                )
	                .type("Human", typeWiring -> typeWiring
	                        .dataFetcher("friends", StarWarsData.getFriendsDataFetcher())
	                )
	                // you can use builder syntax if you don't like the lambda syntax
	                .type("Droid", typeWiring -> typeWiring
	                        .dataFetcher("friends", StarWarsData.getFriendsDataFetcher())
	                )
	                // or full builder syntax if that takes your fancy
	                .type(
	                		TypeRuntimeWiring.newTypeWiring("Character")
	                                .typeResolver(StarWarsData.getCharacterTypeResolver())
	                                .build()
	                )
	                .build();
	    }

}
