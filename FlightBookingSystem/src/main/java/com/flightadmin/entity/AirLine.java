package com.flightadmin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AirLine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String airlineName;
	private Long contactNumber;
	private String description;
	
	
	public AirLine(int id, String airlineName, Long contactNumber, String description) {
		super();
		this.id = id;
		this.airlineName = airlineName;
		this.contactNumber = contactNumber;
		this.description = description;
	}
	
	public AirLine() {
		
	}
	
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getContactAddress() {
		return description;
	}
	public void setContactAddress(String contactAddress) {
		this.description = contactAddress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
