package com.atmosware.testdemo.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerBalance{
	
	private int id;
	private int customerId;
	private double balance;

}