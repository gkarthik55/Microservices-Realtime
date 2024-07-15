package com.spring.os.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.os.common.Payment;
import com.spring.os.common.TransactionRequest;
import com.spring.os.common.TransactionResponse;
import com.spring.os.entity.Orders;
import com.spring.os.repository.OrderRepository;

@Service
public class OrdersService 
{
	@Autowired
	OrderRepository repository;
	
	@Autowired
	@Lazy
	private RestTemplate template;
	
    private String PAYMENT_URL = "http://localhost:8082/payment/doPayment";
	
	//Instead of using the actual URL, we can use the application name itself when API Gateway is set.
    //private String PAYMENT_URL = "http://PAYMENT-SERVICE/payment/doPayment";

	public ResponseEntity<TransactionResponse> addOrder(TransactionRequest request)
	{
      Orders order = request.getOrder();
      
      Payment payment = request.getPayment();
      payment.setOrderId(order.getId());
      payment.setAmount(order.getPrice());
      
      //Rest call for Payment API. 
      Payment paymentResponse = template.postForObject(PAYMENT_URL, payment, Payment.class);
	
		String paymentResponseMsg = paymentResponse.getPaymentStatus().equals("Success")
				? "Payment is Successful. Order is placed."
				: "Failure occured during the Payment. Order added back to Cart.";
   	  
   	  //Saving the Order Information.
   	  repository.save(order);
   	  
   	  TransactionResponse transactionResponse = new TransactionResponse
   			  (order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), paymentResponseMsg);
   	  
	  return new ResponseEntity<>(transactionResponse, HttpStatus.OK);
	}
}
