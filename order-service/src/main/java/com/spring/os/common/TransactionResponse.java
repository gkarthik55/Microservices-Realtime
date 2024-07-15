package com.spring.os.common;

import com.spring.os.entity.Orders;

public class TransactionResponse 
{
    private Orders order;
    private int amount;
    private String transactionId;
    private String message;
    
	public TransactionResponse() 
	{
	}
    
	public TransactionResponse(Orders order, int amount, String transactionId, String message) 
	{
		this.order = order;
		this.amount = amount;
		this.transactionId = transactionId;
		this.message = message;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
