package com.valtech.carassignment.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.carassignment.dto.request.ReservationRequest;
import com.valtech.carassignment.dto.response.ReservationResponse;
import com.valtech.carassignment.service.ReservationService;

@RestController
@RequestMapping({"/reservations"})
public class ReservationController {
	
	private ReservationService reservationService;
	
	@Autowired
	public ReservationController(ReservationService reservationService)
	{
		this.reservationService = reservationService;
	}

	
	@RequestMapping(value = "/available-reservation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LocalDate>> getAvailableReservation( @RequestParam(name = "dateFrom")@DateTimeFormat(iso = ISO.DATE)
    LocalDate dateFrom,@RequestParam(name = "dateto")@DateTimeFormat(iso = ISO.DATE)
    LocalDate dateTo ) {
		
		return ResponseEntity.ok().body(reservationService.getAvailableReservationByDateRange(dateFrom,dateTo));
		
	}
	
	@RequestMapping(value = "/reservation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReservationResponse> postReservation (@Valid @RequestBody ReservationRequest reservationRequest)
	{
		ReservationResponse r = reservationService.postReservation(reservationRequest);
		
		return ResponseEntity.ok().body(r);
		
	}
	
	@RequestMapping(value = "/update-reservation", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReservationResponse> update(@PathVariable("id") int idReservation,
													@Valid @RequestBody ReservationRequest reservationRequest){
	 
		return ResponseEntity.ok().body(reservationService.updateReservation(idReservation, reservationRequest));
	      
	}
	
	@RequestMapping(value = "/cancel-reservation", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	  public void cancelReservation(@PathVariable("reservationId") int reservationId) {
			reservationService.cancelReservation(reservationId);
	  }
	
}
