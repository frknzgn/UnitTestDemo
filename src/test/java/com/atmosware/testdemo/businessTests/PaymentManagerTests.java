package com.atmosware.testdemo.businessTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.junit.jupiter.MockitoExtension;

import com.atmosware.testdemo.business.abstracts.CreditCardService;
import com.atmosware.testdemo.business.abstracts.CustomerService;
import com.atmosware.testdemo.business.abstracts.PosService;
import com.atmosware.testdemo.business.adapters.BankServiceAdapter;
import com.atmosware.testdemo.business.common.exceptions.BusinessException;
import com.atmosware.testdemo.business.concretes.CreditCardManager;
import com.atmosware.testdemo.business.concretes.CustomerManager;
import com.atmosware.testdemo.business.concretes.PaymentManager;
import com.atmosware.testdemo.business.requests.CreateCreditCardRequest;
import com.atmosware.testdemo.business.requests.MakePaymentRequest;
import com.atmosware.testdemo.dataAccess.abstracts.EntityDao;
import com.atmosware.testdemo.dataAccess.concretes.InMemoryDao;

@ExtendWith(MockitoExtension.class)
public class PaymentManagerTests {
	
	 private PaymentManager paymentService;
	 
	 private EntityDao entityDao;	 

	 private CustomerService customerService;

	 private PosService posService;	

	 private CreditCardService creditCardService;
	
	@BeforeEach
	public void setup() {

		entityDao = new InMemoryDao();
		customerService = new CustomerManager(entityDao);
		creditCardService = new CreditCardManager(entityDao);
		posService = new BankServiceAdapter();
		paymentService = new PaymentManager(entityDao, customerService, posService, creditCardService);
		
	}
	
	@Test
	public void throws_exception_when_customer_not_exists() {
		
		MakePaymentRequest paymentRequest = new MakePaymentRequest(150, 9);
		CreateCreditCardRequest createCreditCardRequest = new CreateCreditCardRequest("Furkan Ozgun","123456789","132","09/22");
		
		Executable executable =() -> paymentService.makePayment(paymentRequest, createCreditCardRequest);
	
		Assertions.assertThrows(BusinessException.class, executable);
	
	}
	
	@Test
	public void throws_exception_when_credit_Card_expired() {
		
		MakePaymentRequest paymentRequest = new MakePaymentRequest(150, 1);
		CreateCreditCardRequest createCreditCardRequest = new CreateCreditCardRequest("Furkan Ozgun","123456789","132","09/20");
		
		Executable executable = ()-> paymentService.makePayment(paymentRequest, createCreditCardRequest);
	
		Assertions.assertThrows(BusinessException.class, executable);
	
	}
	
	@Test
	public void throws_exception_when_customer_balance_not_enough() {
		
		MakePaymentRequest paymentRequest = new MakePaymentRequest(99999, 1);
		CreateCreditCardRequest createCreditCardRequest = new CreateCreditCardRequest("Furkan Ozgun","123456789","132","09/29");
		
		Executable executable = ()-> paymentService.makePayment(paymentRequest, createCreditCardRequest);
	
		Assertions.assertThrows(BusinessException.class, executable);
	
	}
}
