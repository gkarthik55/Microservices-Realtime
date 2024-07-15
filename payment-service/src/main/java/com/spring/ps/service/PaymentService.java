package com.spring.ps.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spring.ps.entity.Payment;
import com.spring.ps.repository.PaymentRepository;

@Service
public class PaymentService 
{
    @Autowired
    private PaymentRepository repository;
   
    public ResponseEntity<Payment> doPayment(Payment payment)
    {
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());

        Payment paymentResponse = repository.save(payment);
		
		return new ResponseEntity<>(paymentResponse, HttpStatus.OK);
    }

    public String paymentProcessing()
    {
        //Here ideally an API should be called. Like a 3rd party payment gateway.
        return new Random().nextBoolean()? "Success" : "Failure";
    }

    public Payment findPaymentHistoryByOrderId(int orderId) 
    {
        return repository.findByOrderId(orderId);
    }
}
