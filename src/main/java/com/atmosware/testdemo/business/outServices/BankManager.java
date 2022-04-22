package com.atmosware.testdemo.business.outServices;

import org.springframework.stereotype.Service;

@Service
public class BankManager{

	public boolean doPayment(String cardNumber, String cardCvvCode, String cardHolder,double total,double customerBalance) {
		
		if(customerBalance>=total) {
			return  true;
		}else {
			
		return false;
		
		}
			
	}

}

