package com.atmosware.testdemo.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.atmosware.testdemo.business.abstracts.CustomerService;
import com.atmosware.testdemo.business.common.exceptions.BusinessException;
import com.atmosware.testdemo.business.requests.CreateCustomerRequest;
import com.atmosware.testdemo.dataAccess.abstracts.EntityDao;
import com.atmosware.testdemo.entities.concretes.Customer;

@Service
public class CustomerManager implements CustomerService {
	
	private EntityDao entityDao;
	
	
	public CustomerManager(EntityDao entityDao) {
		
		this.entityDao=entityDao;
		
	}

	@Override
	public void add(CreateCustomerRequest createCustomerRequest) {
		
		checkCustomerExists(createCustomerRequest);
		
		Customer customer = new Customer(entityDao.customers.size()+1,
											createCustomerRequest.getFirstName(),
												createCustomerRequest.getLastName());

		entityDao.customers.add(customer);
		
	}
	
	
	@Override
	public List<Customer> getAll() {
		
		return this.entityDao.customers;
		
	}

	

	public void checkCustomerExists(CreateCustomerRequest createCustomerRequest) {
		
		for (Customer currentCustomer : entityDao.customers) {			
			if(currentCustomer.getFirstName().compareToIgnoreCase(createCustomerRequest.getLastName()) == 0 && (currentCustomer.getLastName().compareToIgnoreCase(createCustomerRequest.getLastName()) ==0)) {
				throw new BusinessException("Customer.Exists");
			}			
		}
	}
	
	public void checkCustomerNotExists(int customerId) throws BusinessException {	
		if(entityDao.customers.size()<customerId) {
			throw new BusinessException("Customer.Not.Exists");
		}
	}


	
}
