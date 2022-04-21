package com.themiya.techmartonline.model;

public class Order {
	
	private int orderId;
	private int productId;
	private String product;
	private int price;
	private String branch;
	private int salesAgentId;
	private String salesAgentName;
	private int driverId;
	private String driverName;
	private String vehicleNumber;
	private String customerEmail;
	private String customerName;
	private String customerAddress;
	private String deliveryStatus;
	private String customerFeedback;
	
	public Order() {

	}

	public Order(int productId, String product, int price, String branch, int salesAgentId, String salesAgentName, int driverId, String driverName, String vehicleNumber, String customerEmail, String customerName, String customerAddress, String deliveryStatus, String customerFeedback) {
		super();
		this.productId = productId;
		this.product = product;
		this.price = price;
		this.branch = branch;
		this.salesAgentId = salesAgentId;
		this.salesAgentName = salesAgentName;
		this.driverId = driverId;
		this.driverName = driverName;
		this.vehicleNumber = vehicleNumber;
		this.customerEmail = customerEmail;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.deliveryStatus = deliveryStatus;
		this.customerFeedback = customerFeedback;
	}

	public Order(int orderId, int productId, String product, int price, String branch, int salesAgentId, String salesAgentName, int driverId, String driverName, String vehicleNumber, String customerEmail, String customerName, String customerAddress, String deliveryStatus, String customerFeedback) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.product = product;
		this.price = price;
		this.branch = branch;
		this.salesAgentId = salesAgentId;
		this.salesAgentName = salesAgentName;
		this.driverId = driverId;
		this.driverName = driverName;
		this.vehicleNumber = vehicleNumber;
		this.customerEmail = customerEmail;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.deliveryStatus = deliveryStatus;
		this.customerFeedback = customerFeedback;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getSalesAgentId() {
		return salesAgentId;
	}

	public void setSalesAgentId(int salesAgentId) {
		this.salesAgentId = salesAgentId;
	}

	public String getSalesAgentName() {
		return salesAgentName;
	}

	public void setSalesAgentName(String salesAgentName) {
		this.salesAgentName = salesAgentName;
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

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getCustomerFeedback() {
		return customerFeedback;
	}

	public void setCustomerFeedback(String customerFeedback) {
		this.customerFeedback = customerFeedback;
	}



}
