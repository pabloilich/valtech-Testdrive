package com.valtech.carassignment.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.carassignment.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	  
		List<Reservation> findAllByRegistrationTimeBetween(
				LocalDateTime registrationTimeStart,
				LocalDateTime registrationTimeEnd);
		
		
		List<Reservation> findByUserUserIdAndRegistrationTimeAfter(int userId , LocalDateTime registrationTime);

		 default List<Reservation> findByRegistrationTime(LocalDate dateRegistration) {

			return findAllByRegistrationTimeBetween(dateRegistration.atStartOfDay(), dateRegistration.plusDays(1).atStartOfDay());

		 }

	
}
