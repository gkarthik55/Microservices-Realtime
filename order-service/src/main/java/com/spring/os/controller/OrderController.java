package com.spring.os.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.os.common.TransactionRequest;
import com.spring.os.common.TransactionResponse;
import com.spring.os.entity.Orders;
import com.spring.os.repository.OrderRepository;
import com.spring.os.service.OrdersService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/orders")
public class OrderController 
{
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private OrderRepository repository;
	
	@GetMapping("/test")
	public ResponseEntity<String> test()
	{
		return new ResponseEntity<>("hello from orders service", HttpStatus.OK);
	}
	
	public static final String ORDER_SERVICE="OrderService";
	
	@PostMapping("/add")
	@CircuitBreaker(name=ORDER_SERVICE, fallbackMethod="addOrderFailureHandle")
	public ResponseEntity<TransactionResponse> addOrder(@RequestBody TransactionRequest request)
	{
		return ordersService.addOrder(request);
	}
	
	// Fallback method signature should match the original method, plus Throwable
	public ResponseEntity<TransactionResponse> addOrderFailureHandle(Exception e)
	{
		String failureMessage = "There is some issue in the Payment Gateway. Please try again later.";
		
		TransactionResponse response = new TransactionResponse();
		response.setMessage(failureMessage);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	@GetMapping("/getAllOrders")
	public ResponseEntity<java.util.List<Orders>> getAllOrders()
	{
		java.util.List<Orders> ordersList = repository.findAll();
		
		return new ResponseEntity<>(ordersList, HttpStatus.OK);
	}
	
	@GetMapping("/getOrderById/{id}")
	public Orders getById(@PathVariable Integer id)
	{
		Orders orderResponse = repository.findById(id).get();
	
		return orderResponse;
	}
}
