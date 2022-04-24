package com.atmosware.testdemo.business.concretes;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atmosware.testdemo.business.abstracts.CreditCardService;
import com.atmosware.testdemo.business.abstracts.CustomerService;
import com.atmosware.testdemo.business.abstracts.PaymentService;
import com.atmosware.testdemo.business.abstracts.PosService;
import com.atmosware.testdemo.business.common.exceptions.BusinessException;
import com.atmosware.testdemo.business.requests.CreateCreditCardRequest;
import com.atmosware.testdemo.business.requests.MakePaymentRequest;
import com.atmosware.testdemo.dataAccess.abstracts.EntityDao;
import com.atmosware.testdemo.entities.concretes.Payment;

@Service
public class PaymentManager implements PaymentService {
	
	private EntityDao entityDao;
	private CustomerService customerService;
	private PosService posService;
	private CreditCardService creditCardService;
	
	@Autowired
	public PaymentManager(EntityDao entityDao, CustomerService customerService, PosService posService, CreditCardService creditCardService) {
		
		this.entityDao = entityDao;
		this.customerService = customerService;
		this.posService = posService;
		this.creditCardService = creditCardService;
			
	}
	

	public void makePayment(MakePaymentRequest makePaymentRequest, CreateCreditCardRequest createCreditCardRequest) throws ParseException {
		
		this.customerService.checkCustomerNotExists(makePaymentRequest.getCustomerId());
		this.creditCardService.checkCreditCardExpired(createCreditCardRequest);
		
		checkPaymentDone(createCreditCardRequest,makePaymentRequest.getTotal(),
				entityDao.customerBalances.get(makePaymentRequest.getCustomerId()-1).getBalance());
		
		entityDao.payments.add(new Payment(entityDao.payments.size()+1, makePaymentRequest.getTotal(), 
												makePaymentRequest.getCustomerId(), entityDao.payments.size()+1,
																									LocalDate.now()));
	}

	@Override
	public List<Payment> getAll() {
		
		return entityDao.payments;
		
	}
	
	private void checkPaymentDone(CreateCreditCardRequest createCreditCardRequest, double total, double customerBalance) {
		
		if(!posService.payment(createCreditCardRequest, total, customerBalance)) {
			throw new BusinessException("Ödeme Başarısız");
		}
		
	}

}
