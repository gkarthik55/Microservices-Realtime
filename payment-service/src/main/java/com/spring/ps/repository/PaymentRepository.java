package com.spring.ps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.ps.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> 
{
	Payment findByOrderId(int orderId);
}
