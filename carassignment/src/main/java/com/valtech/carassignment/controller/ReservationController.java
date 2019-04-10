package com.valtech.carassignment.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping({"/reservations"})
public class ReservationController {
	
	private ReservationService reservationService;
	
	@Autowired
	public ReservationController(ReservationService reservationService)
	{
		this.reservationService = reservationService;
	}

	@ApiOperation(value = "Nos permite obtener las posibles fechas de reservas disponibles, el metodo posee la posibilidad de colocar un rango, si "
			+ "no se coloca rango por defecto considra 90 dias a partir del dia de hoy", 
		      response = LocalDate.class)
	@RequestMapping(value = "/available-reservation", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LocalDate>> getAvailableReservation ( 
			@RequestParam(name = "dateFrom", required=false)@DateTimeFormat(pattern="dd/MM/yyyy") String dateFrom,
			@RequestParam(name = "dateto", required=false) @DateTimeFormat(pattern="dd/MM/yyyy") String dateTo ) {
		
		return ResponseEntity.ok().body(reservationService.getAvailableReservationByDateRange(dateFrom,dateTo));
		
	}
	


	@ApiOperation(value = "Endpoint que nos permite generar una reserva", 
		      response = ReservationResponse.class)
	@RequestMapping(value = "/reservation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReservationResponse> postReservation (@Valid @RequestBody ReservationRequest reservationRequest)
	{
		ReservationResponse r = reservationService.postReservation(reservationRequest);
		
		return ResponseEntity.ok().body(r);
		
	}
	
	
	@ApiOperation(value = "Endpoint que nos permite modificar una reserva considerando el ID de reserva previamente generado", 
		      response = ReservationResponse.class)
	@RequestMapping(value = "/update-reservation", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ReservationResponse> update(@PathVariable("id") int idReservation,
													@Valid @RequestBody ReservationRequest reservationRequest){
	 
		return ResponseEntity.ok().body(reservationService.updateReservation(idReservation, reservationRequest));
	      
	}
	
	@ApiOperation(value = "Endpoint que nos permite cancelar  una reserva previa mediante el ID de reserva previamente generado", 
		      response = ReservationResponse.class)
	@RequestMapping(value = "/cancel-reservation", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	  public void cancelReservation(@RequestParam("reservationId") int reservationId) {
			reservationService.cancelReservation(reservationId);
	  }
	
}
