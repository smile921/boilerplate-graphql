/**
 * 
 */
package org.smile921.graphql.resolver;

import java.util.List;

import org.smile921.graphql.po.Droid;
import org.smile921.graphql.po.Episode;
import org.smile921.graphql.po.Human;
import org.smile921.graphql.repo.HumanRepository;

import com.coxautodev.graphql.tools.GraphQLResolver;

/**
 * @author Frere921
 *
 */
public class QueryType implements GraphQLResolver<Character> {

	private HumanRepository humanRepository;

	public QueryType(HumanRepository humanRepository) {
		this.humanRepository = humanRepository;
	}

	public Character hero(Episode episode) {
		Character cha = this.humanRepository.getCharacterByEpisode(episode);
		return cha;
	}

	public Human human(String id) {
		return this.humanRepository.getHumanById(id);
	}

	public Droid droid(String id) {
		return this.humanRepository.getDroidById(id);
	}
}
