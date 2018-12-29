/**
 * 
 */
package org.smile921.graphql.example;

import java.io.File;

import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

/**
 * @author Frere921
 *
 */
public class TutoialExample {

	/**
	 * @param args https://www.graphql-java-kickstart.com/tools/schema-definition/
	 */
	public static void main(String[] args) {
		SchemaParser parser = new SchemaParser();
		File file = new File("classpath:sdl/starWarsSchema.graphqls");
		TypeDefinitionRegistry registry = parser.parse(file);

	}

}
