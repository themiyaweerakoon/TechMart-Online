<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
<title>TechMart Online</title>
</head>
<body>

<a href="http://localhost:8080/techmart-online/welcome-techmart.jsp">TechMart Home</a>

<br/>

<h1>Admin - Orders Management</h1>

<br/>
	<p>${message}</p>
<br/>

<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link" aria-current="page" href="admin-add-order.jsp">Add Order</a>
  </li>
  <li class="nav-item active">
    <a class="nav-link" href="#">Search/Edit Order</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="getOrders?action=all">All Orders</a>
  </li>
</ul>
<br/>

<div class="container">
	<h2>Search a Order: </h2>
	<br/>
	<form action="getOrders">
		<label for="orderId">Order ID: </label>
		<input id="orderId" name="orderId" type="number" class="form-control"/>
		<input type="hidden" name="action" value="single"/>
		<br/>
		<button type="submit" class="btn btn-info">Search</button>
	</form>
</div>

<br/>

<div class="container">
	<h2>Edit the Order: </h2>
	<br/>
	<form action="updateOrder" method="post">
		<label for="orderId">Order ID:</label>
		<input id="orderId" readonly="readonly" name="orderId" type="number" class="form-control" value="${order.getOrderId()}"/>
		
		<label for="productId">Product ID:</label>
		<input id="productId" name="productId" type="number" class="form-control" value="${order.getProductId()}"/>
		
		<label for="product">Product Name:</label>
		<input id="product" name="product" type="text" class="form-control" value="${order.getProduct()}"/>
		
		<label for="price">Product Price[LKR]:</label>
		<input id="price" name="price" type="number" class="form-control" value="${order.getPrice()}"/>
		
		<label for="branch">Branch:</label>
		<select type="text" id="branch" name="branch" class="form-control" value="${order.getBranch()}">
		<option selected>${order.getBranch()}</option>
		  <option value="Galle">Galle</option>
		  <option value="Kandy">Kandy</option>
		  <option value="Nugegoda">Nugegoda</option>
		  <option value="Gampaha">Gampaha</option>
		  <option value="Kurunegala">Kurunegala</option>
		  <option value="Jaffna">Jaffna</option>
		</select>
		
		<label for="salesAgentId">Sales Agent ID:</label>
		<input id="salesAgentId" name="salesAgentId" type="number" class="form-control" value="${order.getSalesAgentId()}"/>
		
		<label for="salesAgentName">Sales Agent Name:</label>
		<input id="salesAgentName" name="salesAgentName" type="text" class="form-control" value="${order.getSalesAgentName()}"/>
		
		<label for="driverId">Driver ID:</label>
		<input id="driverId" name="driverId" type="number" class="form-control" value="${order.getDriverId()}"/>
		
		<label for="driverName">Driver Name:</label>
		<input id="driverName" name="driverName" type="text" class="form-control" value="${order.getDriverName()}"/>
		
		<label for="vehicleNumber">Vehicle Number:</label>
		<input id="vehicleNumber" name="vehicleNumber" type="text" class="form-control" value="${order.getVehicleNumber()}"/>
		
		<label for="customerEmail">Customer Email:</label>
		<input id="customerEmail" name="customerEmail" type="email" class="form-control" value="${order.getCustomerEmail()}"/>
		
		<label for="customerName">Customer Name:</label>
		<input id="customerName" name="customerName" type="text" class="form-control" value="${order.getCustomerName()}"/>
		
		<label for="customerAddress">Customer Address:</label>
		<input id="customerAddress" name="customerAddress" type="text" class="form-control" value="${order.getCustomerAddress()}"/>
		
		<label for="deliveryStatus">Delivery Status:</label>
		<select type="text" id="deliveryStatus" name="deliveryStatus" class="form-control" value="${order.getDeliveryStatus()}">
		<option selected>${order.getDeliveryStatus()}</option>
		  <option value="Confirmed">Confirmed</option>
		  <option value="Processing">Processing</option>
		  <option value="Out of Delivery">Out of Delivery</option>
		  <option value="Delivered">Delivered</option>
		</select>
		
		<label for="customerFeedback">Customer Feedback:</label>
		<input id="customerFeedback" name="customerFeedback" type="text" class="form-control" value="${order.getCustomerFeedback()}"/>
		<input type="hidden" readonly="readonly" name="action" value="update"/>
		<br/>
		<button type="submit" class="btn btn-warning">Update</button>
	</form>
</div>

</body>
</html>