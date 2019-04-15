package com.valtech.carassignment;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.valtech.carassignment.controller.ReservationController;
import com.valtech.carassignment.dto.request.ReservationRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarAssignmentApplicationTests {
	@Autowired
	ReservationController reservationController;
	
	@Test
	public void contextLoads() {
	}
	@Test
    public void testAddReservationSuccess() 
    {
        ReservationRequest reservation = new ReservationRequest();
        reservation.setEmail("pabloilich@gmail.com");
        reservation.setFirstName("Pablo");
        reservation.setLastName("Ilich");
        reservation.setRegistrationTime("26/04/2019 18:10");
        assertEquals(200, callPostReservation(reservation));
        
    }
     
	@Test
    public void testAddReservationAlreadyExist() 
    {
        ReservationRequest reservation = new ReservationRequest();
        reservation.setEmail("Ruben@gmail.com");
        reservation.setFirstName("Ruben");
        reservation.setLastName("Ilich");
        reservation.setRegistrationTime("26/04/2019 20:00");
 		assertEquals(409, callPostReservation(reservation) );
        
    }
	
	private int callPostReservation (ReservationRequest request)
	{
		return reservationController.postReservation(request).getStatusCodeValue();
	}
	
}
