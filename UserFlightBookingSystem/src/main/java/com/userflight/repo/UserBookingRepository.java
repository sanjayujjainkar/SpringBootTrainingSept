package com.userflight.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userflight.entity.Booking;

public interface UserBookingRepository extends JpaRepository<Booking, Integer> {

}
