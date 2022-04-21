<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
<title>TechMart Online</title>

<style> 
input[type=submit] {
  background-color: #04AA6D;
  border: none;
  color: white;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}
</style>

</head>
<body>

<a href="http://localhost:8080/techmart-online/welcome-techmart.jsp">TechMart Home</a>

<br/>

<h1>Orders List</h1>
<br/>
<br/>
<p>${message}</p>
<p>${deleteMessage}</p>
<br/>

<div class="container">
	<h2>Search Orders: </h2>
	<br/>
	<form action="getDriverVehicle">
		<label for="orderId">Order ID: </label>
		<input id="orderId" name="orderId" type="number" class="form-control"/>
		<input type="hidden" name="action" value="single"/>
		<br/>
		<button type="submit" class="btn btn-info">Search</button>
	</form>
	<br/>
	<form action="getDriverVehicle">
		<label for="driverId">Driver ID: </label>
		<input id="driverId" name="driverId" type="number" class="form-control"/>
		<input type="hidden" name="action" value="single"/>
		<br/>
		<button type="submit" class="btn btn-info">Search</button>
	</form>
</div>

<br/>
<br/>

<div class="container">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Order ID</th>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Product Price[LKR]</th>
				<th>Branch</th>
				<th>Sales Agent ID</th>
				<th>Sales Agent Name</th>
				<th>Driver ID</th>
				<th>Driver Name</th>
				<th>Vehicle Number</th>
				<th>Customer Email</th>
				<th>Customer Name</th>
				<th>Customer Address</th>
				<th>Delivery Status</th>
				<th>Customer Feedback</th>
			</tr>
		</thead>
		
		<tbody>
			<tag:forEach var="order" items="${orderList}">
				<tr>
					<td>${order.getOrderId()}</td>
					<td>${order.getProductId()}</td>
					<td>${order.getProduct()}</td>
					<td>${order.getPrice()}</td>
					<td>${order.getBranch()}</td>
					<td>${order.getSalesAgentId()}</td>
					<td>${order.getSalesAgentName()}</td>
					<td>${order.getDriverId()}</td>
					<td>${order.getDriverName()}</td>
					<td>${order.getVehicleNumber()}</td>
					<td>${order.getCustomerEmail()}</td>
					<td>${order.getCustomerName()}</td>
					<td>${order.getCustomerAddress()}</td>
					<td>${order.getDeliveryStatus()}</td>
					<td>${order.getCustomerFeedback()}</td>
				</tr>
			</tag:forEach>
			<tr>
					<td><label for="getOrderId">${order.getOrderId()}</label></td>
					<td><label for="getProductId">${order.getProductId()}</label></td>
					<td><label for="getProduct">${order.getProduct()}</label></td>
					<td><label for="getPrice">${order.getPrice()}</label></td>
					<td><label for="getBranch">${order.getBranch()}</label></td>
					<td><label for="getSalesAgentId">${order.getSalesAgentId()}</label></td>
					<td><label for="getSalesAgentName">${order.getSalesAgentName()}</label></td>
					<td><label for="getDriverId">${order.getDriverId()}</label></td>
					<td><label for="getDriverName">${order.getDriverName()}</label></td>
					<td><label for="getVehicleNumber">${order.getVehicleNumber()}</label></td>
					<td><label for="getCustomerEmail">${order.getCustomerEmail()}</label></td>
					<td><label for="getCustomerName">${order.getCustomerName()}</label></td>
					<td><label for="getCustomerAddress">${order.getCustomerAddress()}</label></td>
					<td><label for="getDeliveryStatus">${order.getDeliveryStatus()}</label></td>
					<td><label for="getCustomerFeedback">${order.getCustomerFeedback()}</label></td>
			</tr>
		</tbody>
	</table>
</div>
<br/>

<input type="submit" value="Download Report" name="download" onclick="window.print()" /> 

</body>
</html>