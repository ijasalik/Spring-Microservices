package com.ust.userservice.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Matches {
	@JsonProperty(value = "data")
	private List<Match> matches;

	@Override
	public String toString() {
		return "Matches [matches=" + matches + "]";
	}

	public Matches(List<Match> matches) {
		super();
		this.matches = matches;
	}

	public Matches() {

	}

	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}
	

}
