package com.atmosware.testdemo.business.requests;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCreditCardRequest {
		
	private String cardHolder;
	private String cardNumber;
	private String csv;
	@Pattern(regexp="(0[1-9]|1[0-2])\\/([0-9]{2})")
	private String expiration;

}