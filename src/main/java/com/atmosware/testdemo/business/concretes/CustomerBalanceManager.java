package com.atmosware.testdemo.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.atmosware.testdemo.business.abstracts.CustomerBalanceService;
import com.atmosware.testdemo.business.abstracts.CustomerService;
import com.atmosware.testdemo.business.common.exceptions.BusinessException;
import com.atmosware.testdemo.business.requests.CreateCustomerBalanceRequest;
import com.atmosware.testdemo.dataAccess.abstracts.EntityDao;
import com.atmosware.testdemo.dataAccess.concretes.InMemoryDao;
import com.atmosware.testdemo.entities.concretes.CustomerBalance;

@Service
public class CustomerBalanceManager implements CustomerBalanceService{
	
	private EntityDao entityDao;
	private CustomerService customerService;
	
	public CustomerBalanceManager(EntityDao entityDao, CustomerService customerService) {
		
		this.entityDao = entityDao;
		this.customerService = customerService;
		
	}
	
	@Override
	public void add(CreateCustomerBalanceRequest createCustomerBalanceRequest) {
		
		customerService.checkCustomerNotExists(createCustomerBalanceRequest.getCustomerId());
		
		this.entityDao.customerBalances.add(new CustomerBalance(entityDao.customerBalances.size()+1, 
																		createCustomerBalanceRequest.getCustomerId(), 
																				createCustomerBalanceRequest.getBalance()));
		
	}

	@Override
	public List<CustomerBalance> getAll() {
		
		return this.entityDao.customerBalances;
	}

	@Override
	public CustomerBalance getByCustomerId(int customerId) {
		
		customerService.checkCustomerNotExists(customerId);
		
		for (CustomerBalance currentCustomerBalance: entityDao.customerBalances) {
			if(currentCustomerBalance.getCustomerId()==customerId) {
				return currentCustomerBalance;
			}		
		}
		throw new BusinessException("CustomerId.Not.Exists");
	}

}
