package com.themiya.techmartonline.service;

import java.sql.SQLException;
import java.util.List;

import com.themiya.techmartonline.dao.DeliveryManager;
import com.themiya.techmartonline.model.Delivery;

public class DeliveryService {
	
	public Delivery getSpecificDeliveryByDriverId(int driverId) throws ClassNotFoundException, SQLException {
		
		return DeliveryManager.getTheDeliveryByDriverId(driverId);
	}
	
	public List<Delivery> getAllDeliveries() throws ClassNotFoundException, SQLException {
		
		return DeliveryManager.getAllDeliveries();
	}
	
	public boolean addDelivery(Delivery delivery) throws ClassNotFoundException, SQLException {
		
		return DeliveryManager.addDelivery(delivery);
	}
	
	public boolean updateDelivery(Delivery delivery) throws ClassNotFoundException, SQLException {
		
		return DeliveryManager.updateDelivery(delivery);
	}
	
	public boolean deleteDelivery(int driverId) throws ClassNotFoundException, SQLException {
		
		return DeliveryManager.deleteDelivery(driverId);
	}

}
