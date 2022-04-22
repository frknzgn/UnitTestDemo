package com.atmosware.testdemo.business.adapters;

import org.springframework.stereotype.Service;

import com.atmosware.testdemo.business.abstracts.PosService;
import com.atmosware.testdemo.business.outServices.BankManager;
import com.atmosware.testdemo.business.requests.CreateCreditCardRequest;

@Service
public class BankServiceAdapter implements PosService {

	@Override
	public boolean payment(CreateCreditCardRequest createCreditCardRequest, double total, double customerBalance) {
		
		BankManager bankManager = new BankManager();
		
		return bankManager.doPayment(createCreditCardRequest.getCardNumber(),
										createCreditCardRequest.getCsv(),
											createCreditCardRequest.getCardHolder(),
																total, customerBalance);
	}

}
