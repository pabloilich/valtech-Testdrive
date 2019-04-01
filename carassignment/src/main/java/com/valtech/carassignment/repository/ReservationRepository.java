package com.valtech.carassignment.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.carassignment.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	  
		List<Reservation> findAllByRegistrationTimeBetween(
			      LocalDate registrationTimeStart,
			      LocalDate registrationTimeEnd);
		
		Reservation findByRegistrationTime(LocalDate registrationTime);
		
		List<Reservation> findAllByUserIdAndRegistrationTimeAfter(int userId , LocalDate registrationTime);
}
