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

<h1>Delivery Drivers and Vehicles Management</h1>
<br/>
<br/>
<p>${message}</p>
<p>${deleteMessage}</p>
<br/>

<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link" aria-current="page" href="add-delivery.jsp">Add Driver and Vehicle</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="search-edit-delivery.jsp">Search/Edit Driver and Vehicle</a>
  </li>
  <li class="nav-item">
    <a class="nav-link active" href="#">All Drivers and Vehicles</a>
  </li>
</ul>
<br/>

<div class="container">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Driver ID</th>
				<th>Driver Name</th>
				<th>Driver Branch</th>
				<th>Vehicle Number</th>
				<th>Vehicle Type</th>
			</tr>
		</thead>
		
		<tbody>
			<tag:forEach var="delivery" items="${deliveryList}">
				<tr>
					<td>${delivery.getDriverId()}</td>
					<td>${delivery.getDriverName()}</td>
					<td>${delivery.getDriverBranch()}</td>
					<td>${delivery.getVehicleNumber()}</td>
					<td>${delivery.getVehicleType()}</td>
					<td>
						<form action="deleteDelivery" method="post">
							<input type="hidden" name="action" value="delete"/>
							<input type="hidden" name="driverId" value="${delivery.getDriverId()}"/>
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