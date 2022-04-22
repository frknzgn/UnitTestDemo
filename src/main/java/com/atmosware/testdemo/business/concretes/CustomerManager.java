package com.atmosware.testdemo.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.atmosware.testdemo.business.abstracts.CustomerService;
import com.atmosware.testdemo.business.common.exceptions.BusinessException;
import com.atmosware.testdemo.business.requests.CreateCustomerRequest;
import com.atmosware.testdemo.dataAccess.inMemoryDao.InMemoryDao;
import com.atmosware.testdemo.entities.concretes.Customer;

@Service
public class CustomerManager implements CustomerService {
	
	private InMemoryDao inMemoryDao;
	
	
	public CustomerManager(InMemoryDao inMemoryDao) {
		
		this.inMemoryDao=inMemoryDao;
		
	}

	@Override
	public void add(CreateCustomerRequest createCustomerRequest) {
		
		checkCustomerExists(createCustomerRequest);
		
		Customer customer = new Customer(inMemoryDao.customers.size()+1,
											createCustomerRequest.getFirstName(),
												createCustomerRequest.getLastName());

		inMemoryDao.customers.add(customer);
		
	}
	
	
	@Override
	public List<Customer> getAll() {
		
		return this.inMemoryDao.customers;
		
	}

	

	public void checkCustomerExists(CreateCustomerRequest createCustomerRequest) {
		
		for (Customer currentCustomer : inMemoryDao.customers) {			
			if(currentCustomer.getFirstName().compareToIgnoreCase(createCustomerRequest.getLastName()) == 0 && (currentCustomer.getLastName().compareToIgnoreCase(createCustomerRequest.getLastName()) ==0)) {
				throw new BusinessException("Customer.Exists");
			}			
		}
	}
	
	public void checkCustomerNotExists(int customerId) throws BusinessException {	
		if(inMemoryDao.customers.size()<customerId) {
			throw new BusinessException("Customer.Not.Exists");
		}
	}


	
}
