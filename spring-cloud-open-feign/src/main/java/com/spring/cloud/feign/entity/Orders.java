package com.spring.cloud.feign.entity;

public class Orders
{
	private int id;
	private String name;
	private int qty;
	private int price;

	public Orders() 
	{
	}
	
	public Orders(int id, String name, int qty, int price) 
	{
		this.id = id;
		this.name = name;
		this.qty = qty;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", qty=" + qty + ", price=" + price + "]";
	}
}
