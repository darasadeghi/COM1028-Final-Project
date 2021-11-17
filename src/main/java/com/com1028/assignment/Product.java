package com.com1028.assignment;

public class Product {

	private String productCode;
	private String productName;
	private String productLine;
	
	public Product(String productCode, String productName, String productLine) {
			this.productCode = productCode;
			this.productName = productName;
			this.productLine = productLine;
	}

	public String getProductCode() {
		return productCode;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductLine() {
		return productLine;
	}

	
	
}
