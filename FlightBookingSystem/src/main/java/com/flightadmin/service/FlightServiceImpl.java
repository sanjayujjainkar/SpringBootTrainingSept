package com.flightadmin.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.flightadmin.entity.Flight;
import com.flightadmin.repo.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	private FlightRepository repository;

	@Override
	public List<Flight> getAllFlights() {
		return repository.findAll();
	}

	@Override
	public Flight addFlight(Flight flight) {
		// TODO Auto-generated method stub
		return repository.save(flight);
	}

	@Override
	public Flight updateFlight(Integer flightID, Flight flight) {
		Optional<Flight> oldFlightOp = repository.findById(flightID);
		Flight oldFlight = oldFlightOp.get();
		oldFlight.setAirline(flight.getAirline());
		oldFlight.setId(flight.getId());
		oldFlight.setDate(flight.getDate());
		oldFlight.setDestination(flight.getDestination());
		oldFlight.setSource(flight.getSource());
		repository.save(oldFlight);
		return oldFlight;
	}

	@Override
	public Flight deleteFlight(Integer flightID) {
		Optional<Flight> existingFlightOp = repository.findById(flightID);
		Flight existingFlight = existingFlightOp.get();
		repository.delete(existingFlight);
		return existingFlight;
	}
	

}
