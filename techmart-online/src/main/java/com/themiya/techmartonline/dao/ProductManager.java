package com.themiya.techmartonline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.themiya.techmartonline.model.Product;

public class ProductManager {
	
	public static Product getTheProductByProductCode(int productCode) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		// String query = "SELECT * FROM products WHERE productsCode = " + productCode;
		//Statement st = connection.createStatement();
		//ResultSet rs = st.executeQuery(query);
		
		String query = "SELECT * FROM products WHERE productCode=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, productCode);
		
		ResultSet rs = ps.executeQuery();
		
		Product product = new Product();
		if(rs.next())
		{
			product.setProductCode(rs.getInt("productCode"));
			product.setProductName(rs.getString("productName"));
			product.setProductDescription(rs.getString("productDescription"));
			product.setProductPrice(rs.getDouble("productPrice"));
			product.setProductQuantity(rs.getInt("productQuantity"));
			product.setProductSupplier(rs.getString("productSupplier"));
			product.setProductStock(rs.getInt("productStock"));
		}
		
		ps.close();
		connection.close();
		return product;
	}
	
	public static List<Product> getAllProducts() throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		String query = "SELECT * FROM products";
		Statement st = connection.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		List<Product> products = new ArrayList<Product>();
		
		while(rs.next()) {
			
			Product product = new Product(rs.getInt("productCode"), rs.getString("productName"), rs.getString("productDescription"), rs.getDouble("productPrice"), rs.getInt("productQuantity"), rs.getString("productSupplier"), rs.getInt("productStock"));
			products.add(product);
		}
		
		st.close();
		connection.close();
		return products;
		
		
	}
	
	public static boolean addProduct(Product product) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		String query = "INSERT INTO products (productCode, productName, productDescription, productPrice, productQuantity, productSupplier, productStock) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, product.getProductCode());
		ps.setString(2, product.getProductName());
		ps.setString(3, product.getProductDescription());
		ps.setDouble(4, product.getProductPrice());
		ps.setInt(5, product.getProductQuantity());
		ps.setString(6, product.getProductSupplier());
		ps.setInt(7, product.getProductStock());
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}
	
	public static boolean updateProduct(Product product) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		String query = "UPDATE products SET productName=?, productDescription=?, productPrice=?, productQuantity=?, productSupplier=?, productStock=? WHERE productCode=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, product.getProductName());
		ps.setString(2, product.getProductDescription());
		ps.setDouble(3, product.getProductPrice());
		ps.setInt(4, product.getProductQuantity());
		ps.setString(5, product.getProductSupplier());
		ps.setInt(6, product.getProductStock());
		ps.setInt(7, product.getProductCode());
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}
	
	public static boolean deleteProduct(int productCode) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		String query = "DELETE FROM products WHERE productCode=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, productCode);
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}
	
	public static boolean orderProduct(int productCode, String customerEmail) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		String query = "INSERT INTO orders (productId, product, price, customerEmail, customerName, customerAddress, branch) SELECT p.productCode, p.productName, p.productPrice, c.customerEmail, c.customerName, c.customerAddress, c.customerBranch FROM products p, customers c WHERE p.productCode=? and c.customerEmail=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, productCode);
		ps.setString(2, customerEmail);
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}

}
