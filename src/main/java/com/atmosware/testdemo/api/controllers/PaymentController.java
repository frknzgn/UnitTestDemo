package com.atmosware.testdemo.api.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atmosware.testdemo.business.abstracts.PaymentService;
import com.atmosware.testdemo.business.requests.CreateCreditCardRequest;
import com.atmosware.testdemo.business.requests.MakePaymentRequest;
import com.atmosware.testdemo.entities.concretes.Payment;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	
	private PaymentService paymentService;
	
	@Autowired
	public PaymentController(PaymentService paymentService) {
		
		this.paymentService = paymentService;
		
	}
	
	@GetMapping("/getall")
	public List<Payment> getAll(){
		return this.paymentService.getAll();
	}
	
	@GetMapping("/add")
	public void add( MakePaymentRequest makePaymentRequest, CreateCreditCardRequest createCreditCardRequest) throws ParseException{
		
		this.paymentService.makePayment(makePaymentRequest, createCreditCardRequest);
		
	}
}