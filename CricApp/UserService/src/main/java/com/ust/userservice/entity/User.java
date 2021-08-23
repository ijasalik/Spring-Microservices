package com.ust.userservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="user_dataa")
public class User {
	@Id
	private int id;
	private String firstName;
	private String LastName;
	private String password;
	private String userName;
	
	
	public User() {
	}

	public User(String firstName, String lastName, String password) {
		this.firstName = firstName;
		LastName = lastName;
		this.password = password;
	}
	
   


	public User(int id, String firstName, String lastName, String password, String userName) {
		super();
		this.id = id;
		this.firstName = firstName;
		LastName = lastName;
		this.password = password;
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + LastName + ", password=" + password
				+ "]";
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
