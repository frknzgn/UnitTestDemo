package com.atmosware.testdemo.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.atmosware.testdemo.business.abstracts.CustomerBalanceService;
import com.atmosware.testdemo.business.abstracts.CustomerService;
import com.atmosware.testdemo.business.common.exceptions.BusinessException;
import com.atmosware.testdemo.business.requests.CreateCustomerBalanceRequest;
import com.atmosware.testdemo.dataAccess.inMemoryDao.InMemoryDao;
import com.atmosware.testdemo.entities.concretes.CustomerBalance;

@Service
public class CustomerBalanceManager implements CustomerBalanceService{
	
	private InMemoryDao inMemoryDao;
	private CustomerService customerService;
	
	public CustomerBalanceManager(InMemoryDao inMemoryDao, CustomerService customerService) {
		
		this.inMemoryDao = inMemoryDao;
		this.customerService = customerService;
		
	}
	
	@Override
	public void add(CreateCustomerBalanceRequest createCustomerBalanceRequest) {
		
		customerService.checkCustomerNotExists(createCustomerBalanceRequest.getCustomerId());
		
		this.inMemoryDao.customerBalances.add(new CustomerBalance(inMemoryDao.customerBalances.size()+1, 
																		createCustomerBalanceRequest.getCustomerId(), 
																				createCustomerBalanceRequest.getBalance()));
		
	}

	@Override
	public List<CustomerBalance> getAll() {
		
		return this.inMemoryDao.customerBalances;
	}

	@Override
	public CustomerBalance getByCustomerId(int customerId) {
		
		customerService.checkCustomerNotExists(customerId);
		
		for (CustomerBalance currentCustomerBalance: inMemoryDao.customerBalances) {
			if(currentCustomerBalance.getCustomerId()==customerId) {
				return currentCustomerBalance;
			}		
		}
		throw new BusinessException("CustomerId.Not.Exists");
	}

}
