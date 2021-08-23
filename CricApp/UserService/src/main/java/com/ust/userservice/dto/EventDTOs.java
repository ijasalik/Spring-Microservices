package com.ust.userservice.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EventDTOs {
	@JsonProperty(value = "data")
	List<EventDTO> events=new ArrayList<EventDTO>();

	@Override
	public String toString() {
		return "EventDTOs [events=" + events + "]";
	}

	public EventDTOs() {
	}

	public EventDTOs(List<EventDTO> events) {
		super();
		this.events = events;
	}

	public List<EventDTO> getEvents() {
		return events;
	}

	public void setEvents(List<EventDTO> events) {
		this.events = events;
	}
	

}
