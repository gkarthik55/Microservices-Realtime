package com.spring.os.common;

import com.spring.os.entity.Orders;

public class TransactionRequest 
{
	private Orders order;
    private Payment payment;
    
	public TransactionRequest() 
	{
	}
	
	public TransactionRequest(Orders order, Payment payment) 
	{
		this.order = order;
		this.payment = payment;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
}