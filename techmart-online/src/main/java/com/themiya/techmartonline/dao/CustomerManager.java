package com.themiya.techmartonline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.themiya.techmartonline.model.Customer;

public class CustomerManager {
	
	public static Customer getTheCustomerByCustomerEmail(String customerEmail) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		
		String query = "SELECT * FROM customers WHERE customerEmail=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, customerEmail);
		
		ResultSet rs = ps.executeQuery();
		
		Customer customer = new Customer();
		if(rs.next())
		{
			customer.setCustomerEmail(rs.getString("customerEmail"));
			customer.setCustomerName(rs.getString("customerName"));
			customer.setCustomerAddress(rs.getString("customerAddress"));
			customer.setCustomerPassword(rs.getString("customerPassword"));
			customer.setCustomerBranch(rs.getString("customerBranch"));
			customer.setCustomerPaymentMethod(rs.getString("customerPaymentMethod"));

		}
		
		ps.close();
		connection.close();
		return customer;
	}
	
	public static List<Customer> getAllCustomers() throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		String query = "SELECT * FROM customers";
		Statement st = connection.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		List<Customer> customers = new ArrayList<Customer>();
		
		while(rs.next()) {
			
			Customer customer = new Customer(rs.getString("customerEmail"), rs.getString("customerName"), rs.getString("customerAddress"), rs.getString("customerPassword"), rs.getString("customerBranch"), rs.getString("customerPaymentMethod"));
			customers.add(customer);
		}
		
		st.close();
		connection.close();
		return customers;
		
		
	}
	
	public static boolean addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		String query = "INSERT INTO customers (customerEmail, customerName, customerAddress, customerPassword, customerBranch, customerPaymentMethod) VALUES (?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, customer.getCustomerEmail());
		ps.setString(2, customer.getCustomerName());
		ps.setString(3, customer.getCustomerAddress());
		ps.setString(4, customer.getCustomerPassword());
		ps.setString(5, customer.getCustomerBranch());
		ps.setString(6,customer.getCustomerPaymentMethod());
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}
	
	public static boolean updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		String query = "UPDATE customers SET customerName=?, customerAddress=?, customerPassword=?, customerBranch=?, customerPaymentMethod=? WHERE customerEmail=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, customer.getCustomerName());
		ps.setString(2, customer.getCustomerAddress());
		ps.setString(3, customer.getCustomerPassword());
		ps.setString(4, customer.getCustomerBranch());
		ps.setString(5, customer.getCustomerPaymentMethod());
		ps.setString(6, customer.getCustomerEmail());
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}
	
	public static boolean deleteCustomer(String customerEmail) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		String query = "DELETE FROM customers WHERE customerEmail=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, customerEmail);
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}


}
