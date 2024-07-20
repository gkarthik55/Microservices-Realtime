package com.spring.cloud.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.spring.cloud.feign.entity.Orders;

@FeignClient(url="http://localhost:8081/orders", name="USER-CLIENT")
public interface UserClient 
{
	@GetMapping("/getAllOrders")
	public ResponseEntity<java.util.List<Orders>> getAllOrders();
}