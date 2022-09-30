package com.carbroker.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String street;
	private String homenumber;
	private String zipcode;
	private String place;
	private String email;
	private String phone;
	
	
	public Customer(int id, String name, String street, String homenumber, String zipcode, String place, String email,
			String phone) {
		super();
		this.id = id;
		this.name = name;
		this.street = street;
		this.homenumber = homenumber;
		this.zipcode = zipcode;
		this.place = place;
		this.email = email;
		this.phone = phone;
	}


	public Customer() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getHomenumber() {
		return homenumber;
	}


	public void setHomenumber(String homenumber) {
		this.homenumber = homenumber;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}

