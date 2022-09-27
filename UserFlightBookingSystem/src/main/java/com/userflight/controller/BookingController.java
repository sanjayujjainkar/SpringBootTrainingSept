package com.userflight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userflight.entity.Booking;
import com.userflight.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	private BookingService service;
	
	@GetMapping
	List<Booking> getBookings() {
		return service.getBookings();
	}
	
	@PostMapping("/addBooking")
	Booking addBooking(@RequestBody Booking booking) {
		return service.addBooking(booking);
	}
	
	@DeleteMapping("/deleteBooking/{id}")
	Booking deleteBooking(@PathVariable int id) {
		return service.deleteBooking(id);
	}
	
	
}
