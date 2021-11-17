package com.com1028.assignment;


import com.com1028.assignment.Question2;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



import static org.junit.Assert.*;


import org.junit.Test;



public class Question2Test {
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
	public void testQuestion2() {
		BaseQuery();
		String test = "";
	
		try {
		String query = "select paymentDate, customerNumber, checkNumber, amount from payments ORDER BY paymentDate;";
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(query);
		
	
		while (rs.next()) {
			String date = rs.getString("paymentDate");
			String customerNumber = rs.getString("customerNumber");
			String checkNumber = rs.getString("checkNumber");
			String amount = rs.getString("amount");
			test = test +"Date: " + date + "\n"+ "Customer Number: " + customerNumber + "\n"
					+ "Check Number: " + checkNumber + "\n" + "Amount: " + amount + "\n\n";	
			
		}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	
		

		assertEquals(test, Question2.q2());
		}
	
	}
}
