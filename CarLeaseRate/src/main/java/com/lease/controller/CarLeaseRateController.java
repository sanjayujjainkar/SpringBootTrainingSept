package com.lease.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lease.entity.CarUsageContract;

@RestController
@RequestMapping("/lease")
public class CarLeaseRateController {
	
	/**
	 * 
	 * @param carUsageContract : This object contains car cost, mileage, lease period, roi 
	 * @return : lease rate based on the parameters in carUsageContract
	 */
	@PostMapping("/rate") 
	public CarUsageContract leaseRate(@RequestBody CarUsageContract carUsageContract) {
		
		return new CarUsageContract(carUsageContract.getMileage(), 
				carUsageContract.getDuration(), 
				carUsageContract.getRoi(),
				carUsageContract.getNetprice());
	}

}

