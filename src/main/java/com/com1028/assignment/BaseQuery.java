package com.com1028.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class BaseQuery {
	protected Connection con;
	private final String db = "jdbc:mysql://localhost:3306/classicmodels";
	private String uname = "root"; //database username
	private String pwd = ""; //database password

	//establishing connection to database
	public BaseQuery(){
		try {
		      //Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
			con = DriverManager.getConnection( db, uname, pwd);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//creates a list of product object with data extracted from database
	public List<Product> getproducts() {
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			// This is our prepared query, that selects everything from book
			// table
			String query = "SELECT * FROM products";

			Statement s = con.createStatement();
			// Executes the query and stores the results.
			ResultSet results = s.executeQuery(query);

			while (results.next()) {

				/*
				 * Assign results from query to their own variable. We can
				 * reference columns by their name of index value e.g. 0
				 */
				String code = results.getString("productCode");
				String name = results.getString("productName");
				String line = results.getString("productLine");
				products.add(new Product(code, name, line));
			}

		} catch (SQLException e) {
			System.out
					.println("SQLException happened while retrieving records- abort programmme");
			throw new RuntimeException(e);
		}
		return products;
	}
	//creates a list of productLine objects with data extracted from database
	public List<ProductLine> getproductlines(){
		ArrayList <ProductLine> productlines = new ArrayList<ProductLine>();
		try {
			// This is our prepared query, that selects everything from book
			// table
			String query = "SELECT * FROM productlines";

			Statement s = con.createStatement();
			// Executes the query and stores the results.
			ResultSet results = s.executeQuery(query);

			while (results.next()) {

				/*
				 * Assign results from query to their own variable. We can
				 * reference columns by their name of index value e.g. 0
				*/
				
				String line = results.getString("productLine");
				int count = 0;
				
			for (ProductLine temp : productlines)
			{
				if (temp.getProductLine() == line)
					count ++;
					
			}
			if (count == 0)
				productlines.add(new ProductLine(line));
			}

		} catch (SQLException e) {
			System.out
					.println("SQLException happened while retrieving records- abort programmme");
			throw new RuntimeException(e);
		}
		return productlines;
	}
	//creates a list of payment objects with data extracted from database
	public List<Payment> getPayments() {
		ArrayList<Payment> payments = new ArrayList<Payment>();
		try {
			// This is our prepared query, that selects everything from book
			// table
			String query = "SELECT * FROM payments";

			Statement s = con.createStatement();
			// Executes the query and stores the results.
			ResultSet results = s.executeQuery(query);

			while (results.next()) {

				/*
				 * Assign results from query to their own variable. We can
				 * reference columns by their name of index value e.g. 0
				 */
				int customernumber = results.getInt("customerNumber");
				String checknumber = results.getString("checkNumber");
				Date date = results.getDate("paymentDate");
				double amount = results.getDouble("amount");
				
				payments.add(new Payment(customernumber, checknumber, date, amount));
			}

		} catch (SQLException e) {
			System.out
					.println("SQLException happened while retrieving records- abort programmme");
			throw new RuntimeException(e);
		}
		return payments;
		
	}
	
	//creates a list of Order objects with data extracted from database
	public List<Order> getOrders() {
		ArrayList<Order> orders = new ArrayList<Order>();
		try {
			// This is our prepared query, that selects everything from book
			// table
			String query = "SELECT * FROM orders";

			Statement s = con.createStatement();
			// Executes the query and stores the results.
			ResultSet results = s.executeQuery(query);

			while (results.next()) {

				/*
				 * Assign results from query to their own variable. We can
				 * reference columns by their name of index value e.g. 0
				 */
				int customerNumber = results.getInt("customerNumber");
				int orderNumber = results.getInt("orderNumber");
				
				orders.add(new Order(orderNumber, customerNumber));
			}

		} catch (SQLException e) {
			System.out
					.println("SQLException happened while retrieving records- abort programmme");
			throw new RuntimeException(e);
		}
		return orders;
		
	}
	
	//creates a list of Customer objects with data extracted from database
	public List<Customer> getCustomers() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try {
			// This is our prepared query, that selects everything from book
			// table
			String query = "SELECT * FROM customers";

			Statement s = con.createStatement();
			// Executes the query and stores the results.
			ResultSet results = s.executeQuery(query);

			while (results.next()) {

				/*
				 * Assign results from query to their own variable. We can
				 * reference columns by their name of index value e.g. 0
				 */
				int customerNumber = results.getInt("customerNumber");
				String customerName = results.getString("customerName");
				
				customers.add(new Customer(customerNumber, customerName));
			}

		} catch (SQLException e) {
			System.out
					.println("SQLException happened while retrieving records- abort programmme");
			throw new RuntimeException(e);
		}
		return customers;
		
	}
	
	//creates a list of OrderDetail objects with data extracted from database
	public List<OrderDetails> getOrderDetails() {
		ArrayList<OrderDetails> orderDetails = new ArrayList<OrderDetails>();
		try {
			// This is our prepared query, that selects everything from book
			// table
			String query = "SELECT * FROM orderdetails";

			Statement s = con.createStatement();
			// Executes the query and stores the results.
			ResultSet results = s.executeQuery(query);

			while (results.next()) {

				/*
				 * Assign results from query to their own variable. We can
				 * reference columns by their name of index value e.g. 0
				 */
				int orderNumber = results.getInt("orderNumber");
				int quantityOrdered = results.getInt("quantityOrdered");
				double priceEach = results.getDouble("priceEach");
				
				orderDetails.add(new OrderDetails(orderNumber, quantityOrdered, priceEach));
			}

		} catch (SQLException e) {
			System.out
					.println("SQLException happened while retrieving records- abort programmme");
			throw new RuntimeException(e);
		}
		return orderDetails;
		
	}
	
}

