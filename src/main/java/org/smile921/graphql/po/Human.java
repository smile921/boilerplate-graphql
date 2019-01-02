/**
 * 
 */
package org.smile921.graphql.po;

import java.util.List;

/**
 * @author Frere921
 *
 */
public class Human implements Character {

	private String id;
	private String name;
	private List<Character> friends;
	private List<Episode> appearsIn;
	private String homePlanet;

	public Human(String id, String name, List<Character> friends, List<Episode> appearsIn, String homePlanet) {
		this.id = id;
		this.name = name;
		this.friends = friends;
		this.appearsIn = appearsIn;
		this.homePlanet = homePlanet;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Character> getFriends() {
		return friends;
	}

	public void setFriends(List<Character> friends) {
		this.friends = friends;
	}

	public List<Episode> getAppearsIn() {
		return appearsIn;
	}

	public void setAppearsIn(List<Episode> appearsIn) {
		this.appearsIn = appearsIn;
	}

	public String getHomePlanet() {
		return homePlanet;
	}

	public void setHomePlanet(String homePlanet) {
		this.homePlanet = homePlanet;
	}

}
