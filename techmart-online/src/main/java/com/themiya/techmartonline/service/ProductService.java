package com.themiya.techmartonline.service;

import java.sql.SQLException;
import java.util.List;

import com.themiya.techmartonline.dao.ProductManager;
import com.themiya.techmartonline.model.Product;

public class ProductService {
	
	public Product getSpecificProductByProductCode(int productCode) throws ClassNotFoundException, SQLException {
		
		return ProductManager.getTheProductByProductCode(productCode);
	}
	
	public List<Product> getAllProducts() throws ClassNotFoundException, SQLException {
		
		return ProductManager.getAllProducts();
	}
	
	public boolean addProduct(Product product) throws ClassNotFoundException, SQLException {
		
		return ProductManager.addProduct(product);
	}
	
	public boolean updateProduct(Product product) throws ClassNotFoundException, SQLException {
		
		return ProductManager.updateProduct(product);
	}
	
	public boolean deleteProduct(int productCode) throws ClassNotFoundException, SQLException {
		
		return ProductManager.deleteProduct(productCode);
	}
	
	public boolean orderProduct(int productCode, String customerEmail) throws ClassNotFoundException, SQLException {
		
		return ProductManager.orderProduct(productCode, customerEmail);
	}
	

}
