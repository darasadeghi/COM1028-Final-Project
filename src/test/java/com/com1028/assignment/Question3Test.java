package com.com1028.assignment;


import com.com1028.assignment.Question3;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



import static org.junit.Assert.*;


import org.junit.Test;



public class Question3Test {
	protected Connection con;
	private final String db = "jdbc:mysql://localhost:3306/classicmodels";
	private final String uname = "root";
	private final String pwd = "";
	
	public void BaseQuery() {
		try {
		      //Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
			con = DriverManager.getConnection( db, uname, pwd);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void testQuestion3() {
		BaseQuery();
		String test = "";
	
		try {
		String query = "select orderdetails.orderNumber, customers.customerName, orders.customerNumber,\n" + 
				"sum(orderdetails.priceEach*orderdetails.quantityOrdered) as amount\n" + 
				"from orders\n" + 
				"inner join orderdetails on  orders.orderNumber = orderdetails.orderNumber\n" + 
				"inner join customers on orders.customerNumber = customers.customerNumber\n" + 
				"group by orderNumber\n" + 
				"order by orderdetails.orderNumber;";
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(query);
		
	
		while (rs.next()) {
			String orderNumber = rs.getString("orderNumber");
			String customerName = rs.getString("customerName");
			String customerNumber = rs.getString("customerNumber");
			double amount = rs.getDouble("amount");
			if(amount > 25000) {
			test = test +"Order Number: " + orderNumber + "\n"+ "Customer Name: " + customerName + "\n"
					+ "Customer Number: " + customerNumber + "\n" + "Amount: " + String.format("%.2f", amount) + "\n\n";	
			}
		}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	
		

	
		}
	assertEquals(test, Question3.q3());
	}

}
