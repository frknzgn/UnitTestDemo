package com.atmosware.testdemo.dataAccess.abstracts;

import java.util.ArrayList;
import java.util.List;

import com.atmosware.testdemo.entities.concretes.CreditCard;
import com.atmosware.testdemo.entities.concretes.Customer;
import com.atmosware.testdemo.entities.concretes.CustomerBalance;
import com.atmosware.testdemo.entities.concretes.Payment;

public interface EntityDao {
	
	public List<Customer> customers = new ArrayList<Customer>();
	public List<CreditCard> creditCars = new ArrayList<CreditCard>();
	public List<Payment> payments = new ArrayList<Payment>();
	public List<CustomerBalance> customerBalances = new ArrayList<CustomerBalance>();
	
	
}
