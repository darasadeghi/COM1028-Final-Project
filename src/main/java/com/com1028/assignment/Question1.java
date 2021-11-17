package com.com1028.assignment;


import java.util.List;

public class Question1 {
	
	

	public static void main(String [] args ) {
		q1();
	}

	
	public static String q1() {
	
		//Uses base query to get two lists (one with product and the other with productLine)
		 BaseQuery dao = new BaseQuery ();
		 List<ProductLine> productlines = dao.getproductlines();
		 List<Product> products = dao.getproducts();
		
		
		//String used to store complete results (used for testing)
		String result = "";
		
		//combs through product line and product
		for (ProductLine pline : productlines) {
			System.out.print(pline.getProductLine()+"\n \n");
			result = result + pline.getProductLine()+"\n";
			for (Product temp : products) {
				//similar function to "INNER JOIN" function on mySQL
				if (pline.getProductLine().equals(temp.getProductLine())) {
					System.out.print("Name: " + temp.getProductName()+" ");
					System.out.print("Code: " + temp.getProductCode()+ "\n");
					result = result +"Name: " + temp.getProductName() + "Code: " + temp.getProductCode() + "\n";
				}
			}
			System.out.print("\n");
			result = result + "\n";
		}

		return result;
	}
}

