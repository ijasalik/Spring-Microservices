package com.ust.userservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CrickScore {
	@JsonProperty(value = "id")
	private int id;
	@JsonProperty(value =  "round")
	private String name;
	@JsonProperty(value = "starting_at")
	private String date;
	@JsonProperty(value = "localteam_id")
	private String teamOne;
	@JsonProperty(value ="visitorteam_id" )
	private String teamTwo;
	@JsonProperty(value = "type")
	private String type;
	@JsonProperty(value = "toss_won_team_id")
	private String toss;
	@JsonProperty(value = "winner_team_id")
	private String winner;
	@Override
	public String toString() {
		return "CrickScore [id=" + id + ", name=" + name + ", date=" + date + ", teamOne=" + teamOne + ", teamTwo="
				+ teamTwo + ", type=" + type + ", toss=" + toss + ", winner=" + winner + "]";
	}
	public CrickScore() {

	}
	public CrickScore(int id, String name, String date, String teamOne, String teamTwo, String type, String toss,
			String winner) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.teamOne = teamOne;
		this.teamTwo = teamTwo;
		this.type = type;
		this.toss = toss;
		this.winner = winner;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTeamOne() {
		return teamOne;
	}
	public void setTeamOne(String teamOne) {
		this.teamOne = teamOne;
	}
	public String getTeamTwo() {
		return teamTwo;
	}
	public void setTeamTwo(String teamTwo) {
		this.teamTwo = teamTwo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getToss() {
		return toss;
	}
	public void setToss(String toss) {
		this.toss = toss;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	
}


