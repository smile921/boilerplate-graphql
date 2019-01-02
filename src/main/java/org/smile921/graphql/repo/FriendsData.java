/**
 * 
 */
package org.smile921.graphql.repo;

import org.smile921.graphql.po.Character;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

/**
 * @author Frere921
 *
 */
public class FriendsData {

	public static DataFetcher getFriendsDataFetcher() {
		
		return new DataFetcher<Character>() {
			public Character get(DataFetchingEnvironment env){
				Object ctx = env.getContext();
				return null;
			}
		};
	}

}
