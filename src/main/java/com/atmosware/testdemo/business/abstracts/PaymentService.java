package com.atmosware.testdemo.business.abstracts;

import java.text.ParseException;
import java.util.List;

import com.atmosware.testdemo.business.requests.CreateCreditCardRequest;
import com.atmosware.testdemo.business.requests.MakePaymentRequest;
import com.atmosware.testdemo.entities.concretes.Payment;

public interface PaymentService {
	
	void makePayment(MakePaymentRequest makePaymentRequest, CreateCreditCardRequest createCreditCardRequest) throws ParseException;
	List<Payment> getAll();
	
}
