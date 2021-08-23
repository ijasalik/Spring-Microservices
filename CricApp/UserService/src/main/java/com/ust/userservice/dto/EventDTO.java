package com.ust.userservice.dto;



import com.fasterxml.jackson.annotation.JsonProperty;

public class EventDTO {
	@JsonProperty(value = "id")
	private int id;
	@JsonProperty(value = "type")
	private String title;
	@JsonProperty(value = "starting_at")
	private String date;
	@Override
	public String toString() {
		return "EventDTO [id=" + id + ", title=" + title + ", date=" + date + "]";
	}
	public EventDTO(int id, String title, String date) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
	}
	public EventDTO() {

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String string) {
		this.date = string;
	}
	 

}
