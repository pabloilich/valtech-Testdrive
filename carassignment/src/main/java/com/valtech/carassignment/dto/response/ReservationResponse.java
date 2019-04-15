package com.valtech.carassignment.dto.response;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "DTO que representa la respuesta al creaar o modificar una reservacion")
public class ReservationResponse {

	@ApiModelProperty(notes = "Id univoco que representa la reservacion para luego poder operar.", example = "1", required = true)
	private int    id;
	@ApiModelProperty(notes = "Nombre del usuario a realizar el TestDrive", example = "Pablo", required = true, position = 1)
	private String email;
	@ApiModelProperty(notes = "Nombre del usuario a realizar el TestDrive", example = "Ilich", required = true, position = 2)
	private String firstName;
	@ApiModelProperty(notes = "Apellido del usuario a realizar el TestDrive", example = "Ilich", required = true, position = 2)
	private String lastName;
	@ApiModelProperty(notes = "Fecha y hora que se realiza la reservacion (Formato dd/MM/yyyy HH:mm)", example = "20/04/2019 18:30", required = true, position = 3)
	private String registrationTimeDeparture;
	@ApiModelProperty(notes = "Fecha y hora a la que debe devolverse el auto (Formato dd/MM/yyyy HH:mm)", example = "21/04/2019 10:00", required = true, position = 3)
	private String registrationTimeArrival;
	
	
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
	
	public  ReservationResponse (int id, String email ,String firstName, String lastName, String registrationTimeDeparture, String registrationTimeArrival )
	{
		this.id = id;
		this.firstName 					= firstName;
		this.lastName  					= lastName;
		this.email     					= email;
		this.registrationTimeDeparture	= registrationTimeDeparture;
		this.registrationTimeArrival	= registrationTimeArrival;
	}
	public String getRegistrationTimeDeparture() {
		return registrationTimeDeparture;
	}
	public void setRegistrationTimeDeparture(String registrationTimeDeparture) {
		this.registrationTimeDeparture = registrationTimeDeparture;
	}
	public String getRegistrationTimeArrival() {
		return registrationTimeArrival;
	}
	public void setRegistrationTimeArrival(String registrationTimeArrival) {
		this.registrationTimeArrival = registrationTimeArrival;
	}
}
