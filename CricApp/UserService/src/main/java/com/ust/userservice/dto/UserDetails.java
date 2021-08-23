package com.ust.userservice.dto;

public class UserDetails {
	private int id;
	private String firstName;
	private String LastName;
	private String password;
	private String userName;
	
	public UserDetails() {

	}
	

	public UserDetails(int id, String firstName, String lastName, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		LastName = lastName;
		this.password = password;
	}


	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + LastName + ", password="
				+ password + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		this.LastName = lastName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
