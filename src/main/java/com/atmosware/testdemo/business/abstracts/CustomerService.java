package com.atmosware.testdemo.business.abstracts;

import java.util.List;

import com.atmosware.testdemo.business.requests.CreateCustomerRequest;
import com.atmosware.testdemo.entities.concretes.Customer;

public interface CustomerService {
	
	void add(CreateCustomerRequest createCustomerRequest);
	 
	List<Customer> getAll();
	
	void checkCustomerExists(CreateCustomerRequest createCustomerRequest);

	void checkCustomerNotExists(int customerId);
	
}
