package com.spring.ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.ps.entity.Payment;
import com.spring.ps.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController 
{
	@Autowired
	private PaymentService service;

	@GetMapping("/test")
	public ResponseEntity<String> test() 
	{
		return new ResponseEntity<>("hello from payment service", HttpStatus.OK);
	}

	@PostMapping("/doPayment")
	public ResponseEntity<Payment> doPayment(@RequestBody Payment payment) 
	{
		return service.doPayment(payment);
	}

	@GetMapping("/{orderId}")
	public Payment findPaymentHistoryByOrderId(@PathVariable int orderId) 
	{
		return service.findPaymentHistoryByOrderId(orderId);
	}
}