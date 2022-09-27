package com.userflight.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userflight.entity.Booking;
import com.userflight.repo.UserBookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private UserBookingRepository repository;

	@Override
	public List<Booking> getBookings() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Booking addBooking(Booking booking) {
		// TODO Auto-generated method stub
		return repository.save(booking);
	}

	@Override
	public Booking updateBooking(Integer id, Booking booking) {
		// TODO Auto-generated method stub
		/* 
		 * Optional<Flight> oldFlightOp = repository.findById(flightID);
		Flight oldFlight = oldFlightOp.get();
		oldFlight.setAirline(flight.getAirline());
		oldFlight.setId(flight.getId());
		oldFlight.setDate(flight.getDate());
		oldFlight.setDestination(flight.getDestination());
		oldFlight.setSource(flight.getSource());
		repository.save(oldFlight);
		return oldFlight;
		 * */
		return null;
	}

	@Override
	public Booking deleteBooking(Integer id) {
		// TODO Auto-generated method stub
		Optional<Booking> existingBookingOp = repository.findById(id);
		Booking existingBooking = existingBookingOp.get();
		repository.delete(existingBooking);
		return existingBooking;
	}

}
