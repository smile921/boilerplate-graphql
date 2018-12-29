/**
 * 
 */
package org.smile921.graphql.rest;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import graphql.execution.ExecutionStrategy;
import graphql.execution.instrumentation.Instrumentation;
import graphql.execution.instrumentation.SimpleInstrumentation;
import graphql.schema.GraphQLSchema;
import graphql.servlet.DefaultExecutionStrategyProvider;
import graphql.servlet.DefaultGraphQLSchemaProvider;
import graphql.servlet.ExecutionStrategyProvider;
import graphql.servlet.GraphQLContext;
import graphql.servlet.GraphQLSchemaProvider;
import graphql.servlet.GraphQLServletListener;
import graphql.servlet.SimpleGraphQLHttpServlet;

//import graphql.execution.instrumentation.NoOpInstrumentation;
/**
 * @author Frere921
 *
 */

public class SimpleGraphQLServlet {

//	SimpleGraphQLHttpServlet.Builder

	SimpleGraphQLServlet(GraphQLSchema schema) {
		this(schema, new DefaultExecutionStrategyProvider());
	}

	private final GraphQLSchemaProvider schemaProvider;
	private final ExecutionStrategyProvider executionStrategyProvider;
	private final Instrumentation instrumentation;

	public SimpleGraphQLServlet(GraphQLSchema schema, ExecutionStrategy executionStrategy) {
		this(schema, new DefaultExecutionStrategyProvider(executionStrategy));
	}

	public SimpleGraphQLServlet(GraphQLSchema schema, ExecutionStrategyProvider executionStrategyProvider) {
		this(schema, executionStrategyProvider, null, null);
	}

	public SimpleGraphQLServlet(GraphQLSchema schema, ExecutionStrategyProvider executionStrategyProvider,
			List<GraphQLServletListener> listeners, Instrumentation instrumentation) {
		this(new DefaultGraphQLSchemaProvider(schema), executionStrategyProvider, listeners, instrumentation);
	}

	public SimpleGraphQLServlet(GraphQLSchemaProvider schemaProvider, ExecutionStrategyProvider executionStrategyProvider,
			List<GraphQLServletListener> listeners, Instrumentation instrumentation) {
		this.schemaProvider = schemaProvider;
		this.executionStrategyProvider = executionStrategyProvider;
		if (instrumentation == null) {
			this.instrumentation = SimpleInstrumentation.INSTANCE;
		} else {
			this.instrumentation = instrumentation;
		}
	}

	protected GraphQLSchemaProvider getSchemaProvider() {
		return this.schemaProvider;
	}

	protected GraphQLContext createContext(Optional<HttpServletRequest> request,
			Optional<HttpServletResponse> response) {
//	    return new GraphQLContext(request, response);
		return new GraphQLContext();
	}

	protected ExecutionStrategyProvider getExecutionStrategyProvider() {
		return this.executionStrategyProvider;
	}

	protected Instrumentation getInstrumentation() {
		return this.instrumentation;
	}

	protected Map<String, Object> transformVariables(GraphQLSchema schema, String query,
			Map<String, Object> variables) {
		return variables;
	}
}
