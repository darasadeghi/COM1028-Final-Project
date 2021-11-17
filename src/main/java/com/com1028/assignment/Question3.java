package com.com1028.assignment;

import java.util.List;
import java.util.ArrayList;


public class Question3 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		q3();
	
		}
	
	
	public static String q3() {

		//establish connection to database
		BaseQuery dao = new BaseQuery ();
			
		//using baseQuery to get lists of orderDetails, customer and orders
		List<OrderDetails> Details = dao.getOrderDetails();
		List<Customer> customers = dao.getCustomers();
		List<Order> orders = dao.getOrders();
		
		//list to get sum of orders since orderdetails are split into different rows for each product
		List<OrderTotals> combinedOrders = new ArrayList<OrderTotals>();
		
		//sorts through list to see if orders have multiple parts
		for (OrderDetails tmpod : Details) {
			int numberOfParts = 0;
			
			//count for number of parts per order
			for (OrderTotals tmpot : combinedOrders) {
				if(tmpod.getOrderNumber() == tmpot.getOrderNumber())
					++numberOfParts;
			}
			
			//if no part from order exists add new item to array list
			if (numberOfParts == 0)
				combinedOrders.add(new OrderTotals(tmpod.getOrderNumber(),tmpod.getOrderTotal()));
			
			//if other order parts exists, find them and add to the order total
			else
			{
				for (int i = 0; i < combinedOrders.size()  ; i++) {
					if (tmpod.getOrderNumber() == combinedOrders.get(i).getOrderNumber())
						combinedOrders.get(i).setOrderTotal(combinedOrders.get(i).getOrderTotal()+ tmpod.getOrderTotal());
				}
			}
			
		}
		
		//list with only big order
		List <Order> bigOrders = new ArrayList<Order>();
		
		//sort through order totals and orders to find large order
		for (OrderTotals tmpot : combinedOrders ) {
			for (Order tmpOrder : orders) {
				if (tmpot.getOrderTotal() > 25000 && tmpot.getOrderNumber()==tmpOrder.getOrderNumber())
					bigOrders.add(tmpOrder);
			}
		}
		

		//string to store output (used for testing)
		String result = "";
		
		//sort through big orders and customers, once a match is found print information
		for (Order tmpbo : bigOrders) {
			for (Customer tmpcustomer : customers) {
				if(tmpbo.getCustomerNumber() == tmpcustomer.getCustomerNumber()) {
					System.out.println("Order Number: "+ tmpbo.getOrderNumber());
					result = result + "Order Number: " + tmpbo.getOrderNumber() + "\n";
					
					System.out.println("Customer Name: " + tmpcustomer.getCustomerName());
					result = result + "Customer Name: " + tmpcustomer.getCustomerName() + "\n";
					
					System.out.println("Customer Number: " + tmpcustomer.getCustomerNumber());
					result = result + "Customer Number: " + tmpbo.getCustomerNumber() + "\n";
					
					//sorts through big orders to find order amount
					for (OrderTotals tmpot : combinedOrders) {
						if (tmpbo.getOrderNumber() == tmpot.getOrderNumber()) {
							System.out.println("Amount: " + String.format("%.2f", tmpot.getOrderTotal()) + "\n");
							result = result + "Amount: " + String.format("%.2f", tmpot.getOrderTotal()) + "\n\n";
						}
		
					}
					
					
					
				
					
				}
			}
		}
	
		return result;
	}
}







