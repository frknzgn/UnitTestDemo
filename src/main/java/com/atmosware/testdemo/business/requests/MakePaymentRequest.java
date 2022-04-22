package com.atmosware.testdemo.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MakePaymentRequest {
	
	private double total;
	private int customerId;
	
}
