package com.atmosware.testdemo.entities.concretes;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	
	private int id;
	private double total;
	private int customerId;
	private int transactionId;
	private LocalDate date;

}



//Add payment -> Customer, CreditCard params --> request
//Bu müşterinin sistemde olması gerekir.
//Exp. date bu aydan sonra olması gerekir.
//Banka sisteminin kredi kartına onay vermesi gerekir.
//Mocking-mockito
