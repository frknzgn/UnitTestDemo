package com.atmosware.testdemo.business.abstracts;

import java.text.ParseException;

import com.atmosware.testdemo.business.requests.CreateCreditCardRequest;

public interface CreditCardService {
	
	void getAll();
	
	void checkCreditCardExpired(CreateCreditCardRequest createCreditCardRequest) throws ParseException;
	
}
