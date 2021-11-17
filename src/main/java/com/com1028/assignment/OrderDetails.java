package com.com1028.assignment;

public class OrderDetails {

	private int orderNumber;
	private int quantityOrdered;
	private double priceEach;
	private double orderTotal;
	
	public OrderDetails(int orderNumber, int quantityOrdered, double priceEach) {
		this.orderNumber = orderNumber;
		this.quantityOrdered = quantityOrdered;
		this.priceEach = priceEach;
		this.orderTotal = quantityOrdered * priceEach;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public double getPriceEach() {
		return priceEach;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

}
