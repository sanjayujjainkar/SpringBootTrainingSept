package com.caradmin.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String make;
	private String model;
	private String version;
	private int doors;
	private int grossprice;
	private int netprice;
	
	
	public Car(int id, String make, String model, String version, int doors, int grossprice, int netprice) {
		super();
		this.id = id;
		this.make = make;
		this.model = model;
		this.version = version;
		this.doors = doors;
		this.grossprice = grossprice;
		this.netprice = netprice;
	}


	public Car() {
		super();
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}


	public void setMake(String make) {
		this.make = make;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public int getDoors() {
		return doors;
	}


	public void setDoors(int doors) {
		this.doors = doors;
	}


	public int getGrossprice() {
		return grossprice;
	}


	public void setGrossprice(int grossprice) {
		this.grossprice = grossprice;
	}


	public int getNetprice() {
		return netprice;
	}


	public void setNetprice(int netprice) {
		this.netprice = netprice;
	}
	

}
