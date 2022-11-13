package com.userflight.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.userflight.entity.Booking;
import com.userflight.entity.Flight;
import com.userflight.service.BookingService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {
	
	private static final String URL = "http://flightadmin-service/admin/getFlights";

	@Autowired
	private BookingService service;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/user/getBookings")
	List<Booking> getBookings() {
		return service.getBookings();
	}
	
	@PostMapping("/user/addBooking")
	Booking addBooking(@RequestBody Booking booking) {
		return service.addBooking(booking);
	}
	
	@DeleteMapping("/user/deleteBooking/{id}")
	Booking deleteBooking(@PathVariable int id) {
		return service.deleteBooking(id);
	}
	
	@GetMapping("/user/flights")
	List<String> getAllFlight() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<Flight[]> response = restTemplate.exchange(URL, HttpMethod.GET, entity, Flight[].class);
		Flight[] arrFlight = response.getBody();
		System.out.println("List of flights"+ arrFlight + "\n");
		return Arrays.stream(arrFlight)
				.map(flight->flight.toString())
				.collect(Collectors.toList());
	}
	
	
}
