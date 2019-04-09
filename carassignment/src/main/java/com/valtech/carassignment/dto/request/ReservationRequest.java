package com.valtech.carassignment.dto.request;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "DTO que represent el request de una reservacion")

public class ReservationRequest {
	@ApiModelProperty(notes = "Correo electronico univoco para referenciar al usuario.", example = "pablo.ilich@gmail.com", required = true)
	@Email
	private String email;
	@ApiModelProperty(notes = "Nombre del usuario a realizar el TestDrive", example = "Pablo", required = true, position = 1)
	@NotNull(message = "El nombre no debe ser vacio")
	private String firstName;
	@ApiModelProperty(notes = "Apellido del usuario a realizar el TestDrive", example = "Ilich", required = true, position = 2)
	@NotNull(message = "Ingrese el apelido")
	private String lastName;
	@ApiModelProperty(notes = "Fecha y hora que se realiza la reservacion (Formato dd/MM/yyyy HH:mm)", example = "20/04/2019 18:30", required = true, position = 3)
	@NotNull(message = "La fecha no puede ser vacia")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime   registrationTime;
	
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
	public LocalDateTime getRegistrationTime() {
		return registrationTime;
	}
	public void setRegistrationTime(LocalDateTime registrationTime) {
		this.registrationTime = registrationTime;
	}
	

}
