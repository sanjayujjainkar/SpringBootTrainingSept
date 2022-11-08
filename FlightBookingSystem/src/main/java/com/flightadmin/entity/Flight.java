package com.flightadmin.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String airline;
	private String source;
	private String destination;
	private String date;
	private int fare;
	

	public Flight(int id, String airline, String source, String dest, String date, int fare) {
		super();
		this.id = id;
		this.airline = airline;
		this.source = source;
		this.destination = dest;
		this.date = date;
		this.fare = fare;
	}
	
	public Flight() {
		
	}


	public String getAirline() {
		return airline;
	}


	public void setAirline(String airline) {
		this.airline = airline;
	}

	
	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return airline+":"+source+":"+destination+":"+date+":"+fare+"$";
	}

}
