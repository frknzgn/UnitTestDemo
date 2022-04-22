package com.atmosware.testdemo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atmosware.testdemo.business.abstracts.CustomerService;
import com.atmosware.testdemo.business.requests.CreateCustomerRequest;
import com.atmosware.testdemo.entities.concretes.Customer;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		
		this.customerService = customerService;
		
	}
	
	@GetMapping("/getall")
	public List<Customer> getAll(){
		return this.customerService.getAll();
	}
	
	@GetMapping("/add")
	public void add(CreateCustomerRequest createCustomerRequest){
		this.customerService.add(createCustomerRequest);
	}
}
