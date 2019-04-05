package com.valtech.carassignment.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.carassignment.apierror.ExistException;
import com.valtech.carassignment.apierror.NotFoundException;
import com.valtech.carassignment.dto.request.ReservationRequest;
import com.valtech.carassignment.dto.response.ReservationResponse;
import com.valtech.carassignment.model.Reservation;
import com.valtech.carassignment.model.User;
import com.valtech.carassignment.repository.ReservationRepository;
import com.valtech.carassignment.repository.UserRepository;
import com.valtech.carassignment.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{

	private ReservationRepository reservationRepository;
	private UserRepository 		  userRepository;

	@Autowired
	public ReservationServiceImpl(ReservationRepository reservationRepository , UserRepository userRepository)
	{
		this.reservationRepository = reservationRepository;
		this.userRepository        = userRepository;
	}
	
	
	
	@Override
	public Reservation getReservationById(int id) {
		 return reservationRepository.findById(id)
		          .map(m -> {return m;} )
		          .orElseThrow(() ->new NotFoundException("No se encuentra la Reserva"));
	}

	@Override
	public List<LocalDate> getAvailableReservationByDateRange(LocalDate fromDate, LocalDate toDate) {
	
		if(fromDate==null)
			fromDate  = LocalDate.now();
		
		if(toDate == null)
			toDate = LocalDate.now().plusDays(90); //si no colocamos una fecha se deja seteado a 60 dias.
		
		List<LocalDate> datesInRange = getDatesInRange(fromDate, toDate);
	    
		//Obtenemos las fechas reservadas en la DB
	    List<LocalDate> reservations =  reservationRepository.findAllByRegistrationTimeBetween(LocalDateTime.of(fromDate, LocalTime.now())  , LocalDateTime.of(toDate,LocalTime.MAX)).stream().
	    						map(to->
	    								{
	    									return  to.getRegistrationTime().toLocalDate();
	    								}).collect(Collectors.toList());
	    //Excluimos las fechas de la DB
	    return datesInRange.stream().filter(ni -> !reservations.contains(ni)).collect(Collectors.toList());
	    
	}

	

	@Override
	public ReservationResponse postReservation(ReservationRequest reservationRequest) {
		
	    Reservation r = reservationRepository.findByRegistrationTime(reservationRequest.getRegistrationTime().toLocalDate());
		if(r != null)
		{
			throw new ExistException("Ya se encuentra ocupado dicho dia");
		}
		
		if( reservationRequest.getRegistrationTime().getHour()<18)
		{
			throw new ExistException("Puede llevarse el Vehiculo luego de las 18");
		}
		
		//Obtenemos el usuario y si no existe lo creamos.
		
		User user = userRepository.findByEmail(reservationRequest.getEmail());
		if(user == null)
		{
			User userToSave = new User(reservationRequest.getFirstName(),reservationRequest.getLastName(),reservationRequest.getEmail());
			user 		= userRepository.save(userToSave);
		}
		
		//Buscamos si tiene reservas a partir del dia de hoy en adelante ya que solo se permite solo una reserva por cliente.
		List<Reservation> reservations = reservationRepository.findByUserUserIdAndRegistrationTimeAfter ( user.getUser_id(),LocalDateTime.now());
		if(reservations.size()>0)
		{
			throw new ExistException("El usuario ya posee una reserva, no puede realizar otra");
		}
		
		Reservation reservationToSave = new Reservation(reservationRequest.getRegistrationTime(),reservationRequest.getFirstName(),
				reservationRequest.getLastName(),reservationRequest.getEmail());
		
		reservationToSave =reservationRepository.save(reservationToSave);
		
		return new ReservationResponse(reservationToSave.getReservationId(), reservationToSave.getUser().getEmail(),
				reservationToSave.getUser().getFirstname(), reservationToSave.getUser().getLastname(), reservationToSave.getRegistrationTime());
		
	}

	@Override
	public ReservationResponse updateReservation(int idReservation, ReservationRequest reservation) {
		
		return reservationRepository.findById(idReservation).
				 map(record -> {
					 record.setRegistrationTime(reservation.getRegistrationTime());
					 record.setUser(userRepository.findByEmail(reservation.getEmail()));
					 Reservation updated = reservationRepository.save(record);
					 return new ReservationResponse(updated.getReservationId(), updated.getUser().getEmail(),
							 updated.getUser().getFirstname(), updated.getUser().getLastname(), updated.getRegistrationTime());
				 }).orElseThrow(() ->new NotFoundException("No se encuentra dicha reservacion"));
	
	}

	private List<LocalDate> getDatesInRange(LocalDate fromDate, LocalDate toDate) {
		final int days = (int) fromDate.until(toDate, ChronoUnit.DAYS);

		return Stream.iterate(fromDate, d -> d.plusDays(1))
		  .limit(days+1)
		  .collect(Collectors.toList());
	}

	@Override
	public void cancelReservation(int idReservation) {
		  Reservation r = reservationRepository.findById(idReservation).map(reg -> reg).
				  	orElseThrow(() ->new NotFoundException("No se encuentra dicha reservacion y no puede eliminarse"));
		  
		  reservationRepository.delete(r);
		
	}
	
	
}
