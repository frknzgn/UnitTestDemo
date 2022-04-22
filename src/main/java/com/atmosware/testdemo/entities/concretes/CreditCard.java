package com.atmosware.testdemo.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard{
	
	private int id;
	private String cardHolder;
	private String cardNumber;
	private String csv;
	private String expiration;
	
}