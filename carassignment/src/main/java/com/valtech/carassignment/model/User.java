package com.valtech.carassignment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int userId;
	
	private String firstname;
	
	private String lastname;

	private String email;

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUser_id() {
		return userId;
	}

	public void setUser_id(int userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public User(String firstName , String lastName ,String email)
	{
		this.email 		= email;
		this.firstname 	= firstName;
		this.lastname   = lastName;
	}
	public User() {
		
	}
}
