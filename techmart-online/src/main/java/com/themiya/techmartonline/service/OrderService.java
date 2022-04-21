package com.themiya.techmartonline.service;

import java.sql.SQLException;
import java.util.List;

import com.themiya.techmartonline.dao.OrderManager;
import com.themiya.techmartonline.model.Order;

public class OrderService {
	
	public Order getSpecificOrderByOrderId(int orderId) throws ClassNotFoundException, SQLException {
		
		return OrderManager.getTheOrderByOrderId(orderId);
	}
	
	public Order getSpecificOrderByDriverId(int driverId) throws ClassNotFoundException, SQLException {
		
		return OrderManager.getTheOrderByDriverId(driverId);
	}
	
	public List<Order> getAllOrders() throws ClassNotFoundException, SQLException {
		
		return OrderManager.getAllOrders();
	}
	
	public boolean addOrder(Order orderId) throws ClassNotFoundException, SQLException {
		
		return OrderManager.addOrder(orderId);
	}
	
	public boolean updateOrder(Order orderId) throws ClassNotFoundException, SQLException {
		
		return OrderManager.updateOrder(orderId);
	}
	
	public boolean deleteOrder(int orderId) throws ClassNotFoundException, SQLException {
		
		return OrderManager.deleteOrder(orderId);
	}

}
