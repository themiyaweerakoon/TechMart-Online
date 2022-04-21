package com.themiya.techmartonline.service;

import java.sql.SQLException;
import java.util.List;

import com.themiya.techmartonline.dao.CustomerManager;
import com.themiya.techmartonline.model.Customer;

public class CustomerService {
	
	public Customer getSpecificCustomerByCustomerEmail(String customerEmail) throws ClassNotFoundException, SQLException {
		
		return CustomerManager.getTheCustomerByCustomerEmail(customerEmail);
	}
	
	public List<Customer> getAllCustomers() throws ClassNotFoundException, SQLException {
		
		return CustomerManager.getAllCustomers();
	}
	
	public boolean addCustomer(Customer customerEmail) throws ClassNotFoundException, SQLException {
		
		return CustomerManager.addCustomer(customerEmail);
	}
	
	public boolean updateCustomer(Customer customerEmail) throws ClassNotFoundException, SQLException {
		
		return CustomerManager.updateCustomer(customerEmail);
	}
	
	public boolean deleteCustomer(String customerEmail) throws ClassNotFoundException, SQLException {
		
		return CustomerManager.deleteCustomer(customerEmail);
	}

}
