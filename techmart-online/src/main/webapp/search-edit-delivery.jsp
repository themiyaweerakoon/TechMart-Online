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

<h1>Delivery Drivers and Vehicles Management</h1>

<br/>
	<p>${message}</p>
<br/>

<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link" aria-current="page" href="add-delivery.jsp">Add Driver and Vehicle</a>
  </li>
  <li class="nav-item active">
    <a class="nav-link" href="#">Search/Edit Driver and Vehicle</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="getDelivery?action=all">All Drivers and Vehicles</a>
  </li>
</ul>
<br/>

<div class="container">
	<h2>Search a Driver and Vehicle: </h2>
	<br/>
	<form action="getDelivery">
		<label for="driverId">Driver ID: </label>
		<input id="driverId" name="driverId" type="number" class="form-control"/>
		<input type="hidden" name="action" value="single"/>
		<br/>
		<button type="submit" class="btn btn-info">Search</button>
	</form>
</div>

<br/>

<div class="container">
	<h2>Edit the Driver and Vehicle: </h2>
	<br/>
	<form action="updateDelivery" method="post">
		<label for="driverId">Driver ID:</label>
		<input id="driverId" readonly="readonly" name="driverId" type="number" class="form-control" value="${delivery.getDriverId()}"/>
		
		<label for="driverName">Driver Name:</label>
		<input id="driverName" name="driverName" type="text" class="form-control" value="${delivery.getDriverName()}"/>
		
		<label for="driverBranch">Driver Branch:</label>
		<input id="driverBranch" name="driverBranch" type="text" class="form-control" value="${delivery.getDriverBranch()}"/>
		
		<label for="vehicleNumber">Vehicle Number:</label>
		<input id="vehicleNumber" name="vehicleNumber" type="text" class="form-control" value="${delivery.getVehicleNumber()}"/>
		
		<label for="vehicleType">Vehicle Type:</label>
		<input id="vehicleType" name="vehicleType" type="text" class="form-control" value="${delivery.getVehicleType()}"/>

		<input type="hidden" name="action" value="update"/>
		<br/>
		<button type="submit" class="btn btn-warning">Update</button>
	</form>
</div>

</body>
</html>