package com.com1028.assignment;


import com.com1028.assignment.Question1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import static org.junit.Assert.*;


import org.junit.Test;




public class Question1Test {
	
	protected Connection con;
	private final String db = "jdbc:mysql://localhost:3306/classicmodels";
	private final String uname = "root";
	private final String pwd = "";
	
	
	public void BaseQuery(){
		try {
		      //Class.forName("com.mysql.jdbc.Driver");
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
			con = DriverManager.getConnection( db, uname, pwd);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	protected String selectClassicCars() throws SQLException{
		
		try {
		
		String query = "select productName, productCode from products where productLine = \"Classic Cars\";";
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(query);
		
		String result = "";
		while (rs.next()) {
			String name = rs.getString("productName");
			String code = rs.getString("productCode");
			result = result + "Name: " + name + "Code: " + code + "\n";
		}
		return result;
		}
		catch (SQLException e) {
			System.out
					.println("SQLException happened while retrieving records- abort programmme");
			throw new RuntimeException(e);
		}
		
	}
	
	protected String selectMotorcycles() throws SQLException{
	
		try {
		String query = "select productName, productCode from products where productLine = \"Motorcycles\";";
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(query);
		
		String result = "";
		while (rs.next()) {
			String name = rs.getString("productName");
			String code = rs.getString("productCode");
			result = result +"Name: " + name + "Code: " + code + "\n";
		}
		return result;
		}
		catch (SQLException e) {
			System.out
					.println("SQLException happened while retrieving records- abort programmme");
			throw new RuntimeException(e);
		}
		
	}
	
	protected String selectPlanes() throws SQLException{
		String query = "select productName, productCode from products where productLine = \"Planes\";";
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(query);
		
		String result = "";
		while (rs.next()) {
			String name = rs.getString("productName");
			String code = rs.getString("productCode");
			result = result +"Name: " + name + "Code: " + code + "\n";
		}
		return result;
	}
	
	protected String selectShips() throws SQLException{
		String query = "select productName, productCode from products where productLine = \"Ships\";";
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(query);
		
		String result = "";
		while (rs.next()) {
			String name = rs.getString("productName");
			String code = rs.getString("productCode");
			result = result +"Name: " + name + "Code: " + code + "\n";
		}
		return result;
	}
	
	protected String selectTrains() throws SQLException{
		String query = "select productName, productCode from products where productLine = \"Trains\";";
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(query);
		
		String result = "";
		while (rs.next()) {
			String name = rs.getString("productName");
			String code = rs.getString("productCode");
			result = result +"Name: " + name + "Code: " + code + "\n";		}
		return result;
	}
	
	protected String selectTrucksAndBuses() throws SQLException{
		String query = "select productName, productCode from products where productLine = \"Trucks and Buses\";";
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(query);
		
		String result = "";
		while (rs.next()) {
			String name = rs.getString("productName");
			String code = rs.getString("productCode");
			result = result +"Name: " + name + "Code: " + code + "\n";
		}
		return result;
	}
	
	protected String selectVintageCars() throws SQLException{
		String query = "select productName, productCode from products where productLine = \"Vintage Cars\";";
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(query);
		
		String result = "";
		while (rs.next()) {
			String name = rs.getString("productName");
			String code = rs.getString("productCode");
			result = result +"Name: " + name + "Code: " + code + "\n";		}
		return result;
	}
	@Test
	public void testQuestion1() {
		BaseQuery();
		String test ="";
		try {
		
		
			test = "Classic Cars\n" + selectClassicCars() + "\n"
					+ "Motorcycles\n" + selectMotorcycles() + "\n"
					+ "Planes\n" + selectPlanes() + "\n"
					+ "Ships\n" + selectShips() + "\n"
					+ "Trains\n" + selectTrains() + "\n"
					+ "Trucks and Buses\n" + selectTrucksAndBuses() + "\n"
					+ "Vintage Cars\n" + selectVintageCars() + "\n";
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(test, Question1.q1());

	}
}
