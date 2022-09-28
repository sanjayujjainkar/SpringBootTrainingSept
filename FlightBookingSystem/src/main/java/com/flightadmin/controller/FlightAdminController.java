package com.flightadmin.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightadmin.entity.Flight;
import com.flightadmin.service.FlightServiceImpl;

@RestController
public class FlightAdminController {
	
	@Autowired
	private FlightServiceImpl flightService;
	
	@GetMapping("/admin/getFlights")
	public List<Flight> getAllFlights() {
		return flightService.getAllFlights();
	}
	
	@PostMapping("/admin/addFlight")
	public Flight addFlight(@RequestBody Flight flight) {
		return flightService.addFlight(flight);
	}
	
	@PostMapping("/admin/updateFlight/{flightID}")
	public Flight updateFlight(@PathVariable Integer flightID, @RequestBody Flight flight) {
		return flightService.updateFlight(flightID, flight);
	}
	
	@PostMapping("/admin/deleteFlight/{flightID}")
	public Flight deleteFlight(@PathVariable Integer flightID) {
		return flightService.deleteFlight(flightID);
	}

}
