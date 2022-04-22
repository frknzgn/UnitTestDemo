package com.atmosware.testdemo.business.abstracts;

import java.util.List;

import com.atmosware.testdemo.business.requests.CreateCustomerBalanceRequest;
import com.atmosware.testdemo.entities.concretes.CustomerBalance;

public interface CustomerBalanceService {
	
	void add(CreateCustomerBalanceRequest createCustomerBalanceRequest);
	
	List<CustomerBalance> getAll();
	CustomerBalance getByCustomerId(int customerId);
	
}
