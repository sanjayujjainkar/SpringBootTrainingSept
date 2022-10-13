package com.carbroker.service;

import java.util.List;

import com.carbroker.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	
	public Customer getCustomer(Integer id);
	
	public Customer addCustomer(Customer customer);
	
	public Customer updateCustomer(Integer id, Customer customer);
	
	public Customer deleteCustomer(Integer id);

}
