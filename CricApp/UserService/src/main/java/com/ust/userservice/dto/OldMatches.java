package com.ust.userservice.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OldMatches {
	@JsonProperty(value = "data")
	List<Match> oldMatches;

	@Override
	public String toString() {
		return "OldMatches [oldMatches=" + oldMatches + "]";
	}

	public OldMatches() {

	}

	public OldMatches(List<Match> oldMatches) {
		super();
		this.oldMatches = oldMatches;
	}

	public List<Match> getOldMatches() {
		return oldMatches;
	}

	public void setOldMatches(List<Match> oldMatches) {
		this.oldMatches = oldMatches;
	}
	
	

}
