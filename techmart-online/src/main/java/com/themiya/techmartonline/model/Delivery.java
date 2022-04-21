package com.themiya.techmartonline.model;

public class Delivery {
	
	private int driverId;
	private String driverName;
	private String driverBranch;
	private String vehicleNumber;
	private String vehicleType;
	
	public Delivery() {

	}

	public Delivery(String driverName, String driverBranch, String vehicleNumber, String vehicleType) {
		super();
		this.driverName = driverName;
		this.driverBranch = driverBranch;
		this.driverBranch = vehicleNumber;
		this.driverBranch = vehicleType;
	}

	public Delivery(int driverId, String driverName, String driverBranch, String vehicleNumber, String vehicleType) {
		super();
		this.driverId = driverId;
		this.driverName = driverName;
		this.driverBranch = driverBranch;
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverBranch() {
		return driverBranch;
	}

	public void setDriverBranch(String driverBranch) {
		this.driverBranch = driverBranch;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	

}
