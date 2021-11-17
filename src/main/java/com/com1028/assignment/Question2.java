package com.com1028.assignment;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Question2 {

	public static void main(String[] args) {
		 q2();
	}
	
	public static String q2() {
		BaseQuery dao = new BaseQuery ();

		//accesses baseQuery to gather payments list
		List<Payment> payments = dao.getPayments();	
		//uses the comparable implementation in payment to sort List
		Collections.sort(payments);
		Iterator <Payment> iter = payments.iterator();
		
		//string used to store results (used for testing)
		String result = "";
		
		//used for iteration
		Payment tmppayments;
		
		//simply print out information from ordered list of payments by date
		while (iter.hasNext()) {
			tmppayments = iter.next();
			
			System.out.println("Date:" + tmppayments.getPaymentDate());
			result = result + "Date: " +tmppayments.getPaymentDate() + "\n";
			
			System.out.println("Customer Number " + tmppayments.getCustomerNumber());
			result = result + "Customer Number: " +tmppayments.getCustomerNumber() + "\n";
			
			System.out.println("Check Number: " + tmppayments.getCheckNumber());
			result = result + "Check Number: " +tmppayments.getCheckNumber() + "\n";
			
			System.out.println("Amount: " + tmppayments.getAmount() +"\n");
			result = result + "Amount: " +tmppayments.getAmount() + "\n\n";
		
		 }
		return result;
	}

}
