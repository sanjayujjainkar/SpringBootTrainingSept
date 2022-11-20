package com.flightadmin.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightadmin.entity.AirLine;
import com.flightadmin.entity.Flight;
import com.flightadmin.service.AirLineServiceImpl;
import com.flightadmin.service.FlightServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FlightAdminController {

	@Autowired
	private FlightServiceImpl flightService;

	
	@Autowired 
	private AirLineServiceImpl airlineService;
	 

	@GetMapping("/admin/getFlights")
	public List<Flight> getAllFlights() {
		return flightService.getAllFlights();
	}

	@GetMapping("/admin/getFlightStrArray")
	public List<String> getAllFlightsAsStrArray() {
		List<Flight> flights = flightService.getAllFlights();
		return flights.stream().map(flight -> flight.toString()).collect(Collectors.toList());
	}

	@PostMapping("/admin/addFlight")
	public Flight addFlight(@RequestBody Flight flight) {
		return flightService.addFlight(flight);
	}

	@PostMapping("/admin/updateFlight/{flightID}")
	public Flight updateFlight(@PathVariable Integer flightID, @RequestBody Flight flight) {
		return flightService.updateFlight(flightID, flight);
	}

	@DeleteMapping("/admin/deleteFlight/{flightID}")
	public Flight deleteFlight(@PathVariable Integer flightID) {
		return flightService.deleteFlight(flightID);
	}

	// ================AirLine APIs======================

	
	  @GetMapping("/admin/getAirLines") 
	  public List<AirLine> getAirLines() {
		  return airlineService.getAllAirLines(); 
	  }
	  
	  @PostMapping("/admin/addAirLine") 
	  public AirLine addAirLine(@RequestBody AirLine airline) { 
		  return airlineService.addAirLine(airline); 
	  }

}
