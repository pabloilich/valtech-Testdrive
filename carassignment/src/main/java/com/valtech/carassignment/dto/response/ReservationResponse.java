package com.valtech.carassignment.dto.response;

import java.time.LocalDateTime;

public class ReservationResponse {
	private int    id;
	private String email;
	private String firstName;
	private String lastName;
	private LocalDateTime   registrationTimeDeparture;
	private LocalDateTime   registrationTimeArrival;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public  ReservationResponse (int id, String email ,String firstName, String lastName, LocalDateTime registrationTimeDeparture, LocalDateTime registrationTimeArrival )
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName  = lastName;
		this.email     = email;
		this.setRegistrationTimeArrival(registrationTimeArrival);
		this.setRegistrationTimeDeparture(registrationTimeDeparture);

	}
	public LocalDateTime getRegistrationTimeDeparture() {
		return registrationTimeDeparture;
	}
	public void setRegistrationTimeDeparture(LocalDateTime registrationTimeDeparture) {
		this.registrationTimeDeparture = registrationTimeDeparture;
	}
	public LocalDateTime getRegistrationTimeArrival() {
		return registrationTimeArrival;
	}
	public void setRegistrationTimeArrival(LocalDateTime registrationTimeArrival) {
		this.registrationTimeArrival = registrationTimeArrival;
	}
}
