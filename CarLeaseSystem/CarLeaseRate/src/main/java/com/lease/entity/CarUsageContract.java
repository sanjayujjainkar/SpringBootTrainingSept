package com.lease.entity;

public class CarUsageContract {
	
	
	private float mileage;
	private int duration;
	private float roi;
	private int netprice;
	private float leaserate;


	public CarUsageContract(float mileage, int duration, float roi, int netprice) {
		super();
		this.mileage = mileage;
		this.duration = duration;
		this.roi = roi;
		this.netprice = netprice;
		setLeaserate();
	}
	

	public CarUsageContract() {
		super();
	}


	public float getMileage() {
		return mileage;
	}


	public void setMileage(float mileage) {
		this.mileage = mileage;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public float getRoi() {
		return roi;
	}


	public void setRoi(float roi) {
		this.roi = roi;
	}


	public int getNetprice() {
		return netprice;
	}


	public void setNetprice(int netprice) {
		this.netprice = netprice;
	}


	public void setLeaserate() {
		leaserate = ((( mileage / 12 ) * duration )/netprice) + ((( roi / 100 ) * netprice) / 12);
	}
	
	public float getLeaserate() {
		return leaserate;
	}

}
