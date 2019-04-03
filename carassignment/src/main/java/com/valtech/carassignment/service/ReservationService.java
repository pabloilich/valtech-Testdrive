package com.valtech.carassignment.service;

import java.time.LocalDate;
import java.util.List;

import com.valtech.carassignment.dto.request.ReservationRequest;
import com.valtech.carassignment.dto.response.ReservationResponse;
import com.valtech.carassignment.model.Reservation;


public interface ReservationService {
	
	Reservation  	   			getReservationById(int id);
	
	List<LocalDate>	   			getAvailableReservationByDateRange (LocalDate from, LocalDate to);
	
	ReservationResponse		   	postReservation(ReservationRequest reservation);
	
	ReservationResponse		  	updateReservation(int idReservation ,ReservationRequest reservation);
	
	void 			   			cancelReservation(int idReservation);
}
