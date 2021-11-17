package com.com1028.assignment;

import java.util.Date;

public class Payment implements Comparable<Payment> {

	private int customerNumber;
	private String checkNumber;
	private Date paymentDate;
	private double amount;
	
	public Payment(int customerNumber, String checkNumber,  Date paymentDate,  double amount) {
		this.customerNumber= customerNumber;
		this.checkNumber = checkNumber;
		this.paymentDate = paymentDate;
		this.amount = amount;	
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public double getAmount() {
		return amount;
	}
	
	//used to order the list of Payments by date
	public int compareTo(Payment p) {		
		return getPaymentDate().compareTo(p.getPaymentDate());
	}

}
