package com.ust.entity;

import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ust.dto.FavouriteId;



@Entity
@Table(name="favourites")
public class Favourite {
	
	@Id
    @Column(length = 30)
	private Integer matchId;
	@Column(length = 30)
	private String userName;
	private String name;
	private String date;
	private String teamOne;
	private String teamTwo;
	private String type;
	private String toss;
	private String winner;
	@Override
	public String toString() {
		return "Favourite [matchId=" + matchId + ", userName=" + userName + ", name=" + name + ", date=" + date
				+ ", teamOne=" + teamOne + ", teamTwo=" + teamTwo + ", type=" + type + ", toss=" + toss + ", winner="
				+ winner + "]";
	}
	public Favourite(Integer matchId, String userName, String name, String date, String teamOne, String teamTwo,
			String type, String toss, String winner) {
		super();
		this.matchId = matchId;
		this.userName = userName;
		this.name = name;
		this.date = date;
		this.teamOne = teamOne;
		this.teamTwo = teamTwo;
		this.type = type;
		this.toss = toss;
		this.winner = winner;
	}
	public Favourite() {

	}
	public Integer getMatchId() {
		return matchId;
	}
	public void setMatchId(Integer matchId) {
		this.matchId = matchId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
