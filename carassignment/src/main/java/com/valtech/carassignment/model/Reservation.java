package com.valtech.carassignment.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int 		  reservationId;
	
	private LocalDateTime registrationTime;
	
	@OneToOne(fetch=FetchType.EAGER)
	private User		  user;
	
	
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public LocalDateTime getRegistrationTime() {
		return registrationTime;
	}
	public void setRegistrationTime(LocalDateTime registrationTime) {
		this.registrationTime = registrationTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Reservation (LocalDateTime registrationTime, String firstname , String lastName, String email )
	{
		this.registrationTime = registrationTime;
		User user = new User(firstname,lastName,email);
		this.user = user;
	}

}
