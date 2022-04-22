package com.atmosware.testdemo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atmosware.testdemo.business.abstracts.CustomerBalanceService;
import com.atmosware.testdemo.business.requests.CreateCustomerBalanceRequest;
import com.atmosware.testdemo.entities.concretes.CustomerBalance;

@RestController
@RequestMapping("/api/customerbalances")
public class CustomerBalanceController {
	
	private CustomerBalanceService customerBalanceService;
	
	@Autowired
	public CustomerBalanceController(CustomerBalanceService customerBalanceService) {
		
		this.customerBalanceService = customerBalanceService;
		
	}
	
	@GetMapping("/getall")
	public List<CustomerBalance> getAll(){
		return this.customerBalanceService.getAll();
	}
	
	@GetMapping("/add")
	public void add(CreateCustomerBalanceRequest createCustomerBalanceRequest){
		this.customerBalanceService.add(createCustomerBalanceRequest);
	}
}