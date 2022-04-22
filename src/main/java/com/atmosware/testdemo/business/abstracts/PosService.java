package com.atmosware.testdemo.business.abstracts;

import com.atmosware.testdemo.business.requests.CreateCreditCardRequest;

public interface PosService {
		
	public boolean payment(CreateCreditCardRequest createCreditCardRequest,double total,double customerBalance);
		
}
