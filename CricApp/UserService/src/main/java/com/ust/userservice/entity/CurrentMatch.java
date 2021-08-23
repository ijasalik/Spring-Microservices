package com.ust.userservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@Table(name = "current_match")
public class CurrentMatch {
	@Id
	private int id;
	private String name;
	private String teamOne;
	private String teamTwo;
	private String type;
	private String toss;

	private String Score;
	private String current_over;
	@Override
	public String toString() {
		return "CurrentMatch [id=" + id + ", name=" + name + ", teamOne=" + teamOne + ", teamTwo=" + teamTwo + ", type="
				+ type + ", toss=" + toss + ", Score=" + Score + ", current_over=" + current_over + "]";
	}
	public CurrentMatch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CurrentMatch(int id, String name, String teamOne, String teamTwo, String type, String toss, String score,
			String current_over) {
		super();
		this.id = id;
		this.name = name;
		this.teamOne = teamOne;
		this.teamTwo = teamTwo;
		this.type = type;
		this.toss = toss;
		Score = score;
		this.current_over = current_over;
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
	public String getScore() {
		return Score;
	}
	public void setScore(String score) {
		Score = score;
	}
	public String getCurrent_over() {
		return current_over;
	}
	public void setCurrent_over(String current_over) {
		this.current_over = current_over;
	}
    
	

}
