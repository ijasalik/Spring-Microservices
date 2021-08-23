package com.ust.dto;

import javax.persistence.Column;

public class FavouriteDTO {
	
	private Integer matchId;
	@Column(length = 30)
	private Integer id;
	private String name;
	private String date;
	private String teamOne;
	private String teamTwo;
	private String type;
	private String toss;
	private String winner;
	public FavouriteDTO(Integer matchId, Integer id, String name, String date, String teamOne, String teamTwo,
			String type, String toss, String winner) {
		super();
		this.matchId = matchId;
		this.id = id;
		this.name = name;
		this.date = date;
		this.teamOne = teamOne;
		this.teamTwo = teamTwo;
		this.type = type;
		this.toss = toss;
		this.winner = winner;
	}
	public FavouriteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "FavouriteDTO [matchId=" + matchId + ", id=" + id + ", name=" + name + ", date=" + date + ", teamOne="
				+ teamOne + ", teamTwo=" + teamTwo + ", type=" + type + ", toss=" + toss + ", winner=" + winner + "]";
	}
	public Integer getMatchId() {
		return matchId;
	}
	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
