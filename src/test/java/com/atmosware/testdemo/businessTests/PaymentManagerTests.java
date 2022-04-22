package com.atmosware.testdemo.businessTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.atmosware.testdemo.business.abstracts.CreditCardService;
import com.atmosware.testdemo.business.abstracts.CustomerService;
import com.atmosware.testdemo.business.abstracts.PaymentService;
import com.atmosware.testdemo.business.abstracts.PosService;
import com.atmosware.testdemo.business.common.exceptions.BusinessException;
import com.atmosware.testdemo.business.concretes.CreditCardManager;
import com.atmosware.testdemo.business.concretes.CustomerManager;
import com.atmosware.testdemo.business.concretes.PaymentManager;
import com.atmosware.testdemo.business.requests.CreateCreditCardRequest;
import com.atmosware.testdemo.business.requests.MakePaymentRequest;
import com.atmosware.testdemo.dataAccess.inMemoryDao.InMemoryDao;

@ExtendWith(MockitoExtension.class)
public class PaymentManagerTests {
	
	 @InjectMocks
	 private PaymentManager paymentService;
	 
	 private InMemoryDao inMemoryDao;	 
	 @Mock
	 private CustomerService customerService;
	 @Mock
	 private PosService posService;	
	 @Mock
	 private CreditCardService creditCardService;
	
	@BeforeEach
	public void setup() {
//		customerService = Mockito.mock(CustomerService.class);
//		posService = Mockito.mock(PosService.class);
//		creditCardService = Mockito.mock(CreditCardService.class);
		inMemoryDao = new InMemoryDao();
		paymentService = new PaymentManager(inMemoryDao, customerService, posService, creditCardService);
	}
	
	@Test
	public void throws_exception_when_customer_not_exists() {
		
		MakePaymentRequest paymentRequest = new MakePaymentRequest(150, 9);
		CreateCreditCardRequest createCreditCardRequest = new CreateCreditCardRequest("Furkan Ozgun","123456789","132","09/22");
		
		Executable executable = ()-> paymentService.makePayment(paymentRequest, createCreditCardRequest);
	
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
		
		MakePaymentRequest paymentRequest = new MakePaymentRequest(999999, 1);
		CreateCreditCardRequest createCreditCardRequest = new CreateCreditCardRequest("Furkan Ozgun","123456789","132","09/29");
		
		Executable executable = ()-> paymentService.makePayment(paymentRequest, createCreditCardRequest);
	
		Assertions.assertThrows(BusinessException.class, executable);
	
	}
}
