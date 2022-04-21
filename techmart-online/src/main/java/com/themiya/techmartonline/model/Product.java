package com.themiya.techmartonline.model;

public class Product {
	
	private int productCode;
	private String productName;
	private String productDescription;
	private double productPrice;
	private int productQuantity;
	private String productSupplier;
	private int productStock;
	
	public Product() {

	}

	public Product(String productName, String productDescription, double productPrice, int productQuantity, String productSupplier, int productStock) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productSupplier = productSupplier;
		this.productStock = productStock;
	}

	public Product(int productCode, String productName, String productDescription, double productPrice, int productQuantity, String productSupplier, int productStock) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productSupplier = productSupplier;
		this.productStock = productStock;
	}


	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductSupplier() {
		return productSupplier;
	}

	public void setProductSupplier(String productSupplier) {
		this.productSupplier = productSupplier;
	}
	
	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}


}
