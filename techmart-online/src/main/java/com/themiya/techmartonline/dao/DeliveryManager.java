package com.themiya.techmartonline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.themiya.techmartonline.model.Delivery;

public class DeliveryManager {
	
	public static Delivery getTheDeliveryByDriverId(int driverId) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		String query = "SELECT * FROM deliveries WHERE driverId=?";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, driverId);
		
		ResultSet rs = ps.executeQuery();
		
		Delivery delivery = new Delivery();
		if(rs.next())
		{
			delivery.setDriverId(rs.getInt("driverId"));
			delivery.setDriverName(rs.getString("driverName"));
			delivery.setDriverBranch(rs.getString("driverBranch"));
			delivery.setVehicleNumber(rs.getString("vehicleNumber"));
			delivery.setVehicleType(rs.getString("vehicleType"));
		}
		
		ps.close();
		connection.close();
		return delivery;
	}
	
	public static List<Delivery> getAllDeliveries() throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		String query = "SELECT * FROM deliveries";
		Statement st = connection.createStatement();
		
		ResultSet rs = st.executeQuery(query);
		
		List<Delivery> deliveries = new ArrayList<Delivery>();
		
		while(rs.next()) {
			
			Delivery delivery = new Delivery(rs.getInt("driverId"), rs.getString("driverName"), rs.getString("driverBranch"), rs.getString("vehicleNumber"), rs.getString("vehicleType"));
			deliveries.add(delivery);
		}
		
		st.close();
		connection.close();
		return deliveries;
		
		
	}
	
	public static boolean addDelivery(Delivery delivery) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		String query = "INSERT INTO deliveries (driverName, driverBranch, vehicleNumber, vehicleType) VALUES (?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, delivery.getDriverName());
		ps.setString(2, delivery.getDriverBranch());
		ps.setString(3, delivery.getVehicleNumber());
		ps.setString(4, delivery.getVehicleType());
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}
	
	public static boolean updateDelivery(Delivery delivery) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		String query = "UPDATE deliveries SET driverName=?, driverBranch=?, vehicleNumber=?, vehicleType=? WHERE driverId=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1, delivery.getDriverName());
		ps.setString(2, delivery.getDriverBranch());
		ps.setString(3, delivery.getVehicleNumber());
		ps.setString(4, delivery.getVehicleType());
		ps.setInt(5, delivery.getDriverId());

		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}
	
	public static boolean deleteDelivery(int driverId) throws ClassNotFoundException, SQLException {
		
		DbConnector connector = new DbConnectorImplMySql();
		Connection connection = connector.getConnection();
		
		String query = "DELETE FROM deliveries WHERE driverId=?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setInt(1, driverId);
		
		boolean result = ps.executeUpdate() > 0;
		ps.close();
		connection.close();
		
		return result;
	}

}