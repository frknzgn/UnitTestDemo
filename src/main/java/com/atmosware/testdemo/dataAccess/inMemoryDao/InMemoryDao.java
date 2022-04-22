package com.atmosware.testdemo.dataAccess.inMemoryDao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.atmosware.testdemo.entities.concretes.CreditCard;
import com.atmosware.testdemo.entities.concretes.Customer;
import com.atmosware.testdemo.entities.concretes.CustomerBalance;
import com.atmosware.testdemo.entities.concretes.Payment;

@Repository
@Component
public class InMemoryDao {
	
public List<Customer> customers = new ArrayList<Customer>();
public List<CreditCard> creditCars = new ArrayList<CreditCard>();
public List<Payment> payments = new ArrayList<Payment>();
public List<CustomerBalance> customerBalances = new ArrayList<CustomerBalance>();
	
	public InMemoryDao() {
		
		customers.add(new Customer(1,"furkan","ozgun"));
		customers.add(new Customer(2,"umut","taze"));
		customers.add(new Customer(3,"fatih","cakir"));
		
		creditCars.add(new CreditCard(1,"furkan","1234","123","02/25"));
		creditCars.add(new CreditCard(2,"umut","12345","121","02/25"));
		creditCars.add(new CreditCard(3,"fatih","12346","122","02/25"));
		
		customerBalances.add(new CustomerBalance(1, 1, 1000));
		customerBalances.add(new CustomerBalance(2, 2, 1500));
		customerBalances.add(new CustomerBalance(3, 3, 1900));
	}	
	
}
