package com.themiya.techmartonline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.themiya.techmartonline.model.Order;

public class OrderManager {
	
	public static Order getTheOrderByOrderId(int orderId) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		
		String query = "SELECT * FROM orders WHERE orderId=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, orderId);
		
		ResultSet rs = ps.executeQuery();
		
		Order order = new Order();
		if(rs.next())
		{

			order.setOrderId(rs.getInt("orderId"));
			order.setProductId(rs.getInt("productId"));
			order.setProduct(rs.getString("product"));
			order.setPrice(rs.getInt("price"));
			order.setBranch(rs.getString("branch"));
			order.setSalesAgentId(rs.getInt("salesAgentId"));
			order.setSalesAgentName(rs.getString("salesAgentName"));
			order.setDriverId(rs.getInt("driverId"));
			order.setDriverName(rs.getString("driverName"));
			order.setVehicleNumber(rs.getString("vehicleNumber"));
			order.setCustomerEmail(rs.getString("customerEmail"));
			order.setCustomerName(rs.getString("customerName"));
			order.setCustomerAddress(rs.getString("customerAddress"));
			order.setDeliveryStatus(rs.getString("deliveryStatus"));
			order.setCustomerFeedback(rs.getString("customerFeedback"));

		}
		
		ps.close();
		connection.close();
		return order;
	}
	
	public static Order getTheOrderByDriverId(int driverId) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		
		String query = "SELECT * FROM orders WHERE driverId=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, driverId);
		
		ResultSet rs = ps.executeQuery();
		
		Order order = new Order();
		if(rs.next())
		{

			order.setOrderId(rs.getInt("orderId"));
			order.setProductId(rs.getInt("productId"));
			order.setProduct(rs.getString("product"));
			order.setPrice(rs.getInt("price"));
			order.setBranch(rs.getString("branch"));
			order.setSalesAgentId(rs.getInt("salesAgentId"));
			order.setSalesAgentName(rs.getString("salesAgentName"));
			order.setDriverId(rs.getInt("driverId"));
			order.setDriverName(rs.getString("driverName"));
			order.setVehicleNumber(rs.getString("vehicleNumber"));
			order.setCustomerEmail(rs.getString("customerEmail"));
			order.setCustomerName(rs.getString("customerName"));
			order.setCustomerAddress(rs.getString("customerAddress"));
			order.setDeliveryStatus(rs.getString("deliveryStatus"));
			order.setCustomerFeedback(rs.getString("customerFeedback"));

		}
		
		ps.close();
		connection.close();
		return order;
	}
	
	public static List<Order> getAllOrders() throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		String query = "SELECT * FROM orders";
		Statement st = connection.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		List<Order> orders = new ArrayList<Order>();
		
		while(rs.next()) {
			
			Order order = new Order(rs.getInt("orderId"), rs.getInt("productId"), rs.getString("product"), rs.getInt("price"), rs.getString("branch"), rs.getInt("salesAgentId"), rs.getString("salesAgentName"), rs.getInt("driverId"), rs.getString("driverName"), rs.getString("vehicleNumber"), rs.getString("customerEmail"), rs.getString("customerName"), rs.getString("customerAddress"), rs.getString("deliveryStatus"), rs.getString("customerFeedback"));
			orders.add(order);
		}
		
		st.close();
		connection.close();
		return orders;
		
		
	}
	
	public static boolean addOrder(Order order) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		String query = "INSERT INTO orders (productId, product, price, branch, salesAgentId, salesAgentName, driverId, driverName, vehicleNumber, customerEmail, customerName, customerAddress, deliveryStatus, customerFeedback) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, order.getProductId());
		ps.setString(2, order.getProduct());
		ps.setInt(3, order.getPrice());
		ps.setString(4, order.getBranch());
		ps.setInt(5, order.getSalesAgentId());
		ps.setString(6, order.getSalesAgentName());
		ps.setInt(7, order.getDriverId());
		ps.setString(8, order.getDriverName());
		ps.setString(9, order.getVehicleNumber());
		ps.setString(10, order.getCustomerEmail());
		ps.setString(11, order.getCustomerName());
		ps.setString(12, order.getCustomerAddress());
		ps.setString(13, order.getDeliveryStatus());
		ps.setString(14, order.getCustomerFeedback());
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}
	
	public static boolean updateOrder(Order order) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		String query = "UPDATE orders SET productId=?, product=?, price=?, branch=?, salesAgentId=?, salesAgentName=?, driverId=?, driverName=?, vehicleNumber=?, customerEmail=?, customerName=?, customerAddress=?, deliveryStatus=?, customerFeedback=? WHERE orderId=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, order.getProductId());
		ps.setString(2, order.getProduct());
		ps.setInt(3, order.getPrice());
		ps.setString(4, order.getBranch());
		ps.setInt(5, order.getSalesAgentId());
		ps.setString(6, order.getSalesAgentName());
		ps.setInt(7, order.getDriverId());
		ps.setString(8, order.getDriverName());
		ps.setString(9, order.getVehicleNumber());
		ps.setString(10, order.getCustomerEmail());
		ps.setString(11, order.getCustomerName());
		ps.setString(12, order.getCustomerAddress());
		ps.setString(13, order.getDeliveryStatus());
		ps.setString(14, order.getCustomerFeedback());
		ps.setInt(15, order.getOrderId());
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}
	
	public static boolean deleteOrder(int orderId) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		String query = "DELETE FROM orders WHERE orderId=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, orderId);
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}


}
