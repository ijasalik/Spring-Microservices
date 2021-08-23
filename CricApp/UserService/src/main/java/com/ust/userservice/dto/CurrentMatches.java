package com.ust.userservice.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentMatches {
	@JsonProperty(value = "data")
	List<CrickScore> cricScore;

	public CurrentMatches(List<CrickScore> cricScore) {
		super();
		this.cricScore = cricScore;
	}

	public CurrentMatches() {
	}

	@Override
	public String toString() {
		return "CurrentMatches [cricScore=" + cricScore + "]";
	}

	public List<CrickScore> getCricScore() {
		return cricScore;
	}

	public void setCricScore(List<CrickScore> cricScore) {
		this.cricScore = cricScore;
	}
	

}
