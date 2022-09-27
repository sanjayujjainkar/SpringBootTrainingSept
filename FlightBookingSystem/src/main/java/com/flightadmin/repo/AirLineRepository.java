package com.flightadmin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightadmin.entity.AirLine;


@Repository
public interface AirLineRepository extends JpaRepository<AirLine, Integer>  {

}
