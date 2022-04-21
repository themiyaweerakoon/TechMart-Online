<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
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
<br/>
<p>${message}</p>
<p>${deleteMessage}</p>
<br/>

<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link" aria-current="page" href="admin-add-order.jsp">Add Order</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="admin-search-edit-order.jsp">Search/Edit Order</a>
  </li>
  <li class="nav-item">
    <a class="nav-link active" href="#">All Orders</a>
  </li>
</ul>
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
					<td>
						<form action="deleteOrder" method="post">
							<input type="hidden" name="action" value="delete"/>
							<input type="hidden" name="orderId" value="${order.getOrderId()}"/>
							<button type="submit" class="btn btn-danger">Delete</button> 
						</form>
					</td>
				</tr>
			</tag:forEach>
		</tbody>
	</table>
</div>

</body>
</html>