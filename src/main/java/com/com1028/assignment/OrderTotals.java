package com.com1028.assignment;

public class OrderTotals {

	private int orderNumber;
	private double orderTotal;
	
	public OrderTotals(int orderNumber, double orderTotal) {
		this.orderNumber = orderNumber;
		this.orderTotal = orderTotal;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public int getOrderNumber() {
		return orderNumber;
	}
	
	
}
