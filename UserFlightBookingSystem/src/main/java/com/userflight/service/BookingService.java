package com.userflight.service;

import java.util.List;

import com.userflight.entity.Booking;

public interface BookingService {
	
	public List<Booking> getBookings();
	
	public Booking addBooking(Booking booking);
	
	public Booking updateBooking(Integer id, Booking booking);
	
	public Booking deleteBooking(Integer id);

}
