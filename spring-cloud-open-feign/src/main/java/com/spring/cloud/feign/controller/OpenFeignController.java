package com.spring.cloud.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.feign.client.UserClient;
import com.spring.cloud.feign.entity.Orders;

@RestController
public class OpenFeignController 
{
	@Autowired
	private UserClient client;
	
	@GetMapping("/fetch-orders")
	public ResponseEntity<java.util.List<Orders>> getAllOrders()
	{
		return client.getAllOrders();
	}
}
