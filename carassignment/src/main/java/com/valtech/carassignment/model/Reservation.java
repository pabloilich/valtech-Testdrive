package com.valtech.carassignment.model;

import java.time.LocalDateTime;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int 		  reservationId;
	
	private LocalDateTime registrationTime;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private User		  user;
	
	@Version
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar  	  version;
	
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
	
	public Reservation (LocalDateTime registrationTime, User  user )
	{
		this.registrationTime = registrationTime;
		this.user = user;
	}
	public Reservation ()
	{
		
	}
}
