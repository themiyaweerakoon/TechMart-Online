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
    <a class="nav-link active" aria-current="page" href="#">Add Driver and Vehicle</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="search-edit-delivery.jsp">Search/Edit Driver and Vehicle</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="getDelivery?action=all">All Drivers and Vehicles</a>
  </li>
</ul>

<br/>

<div class="container">
	<h2>Add a Driver and Vehicle: </h2>
	<br/>
	<form action="addDelivery" method="post">
		<label for="driverName">Enter Driver Name:</label>
		<input type="text" id="driverName" name="driverName" class="form-control"/>
		
		<label for="driverBranch">Enter Driver Branch:</label>
		<br/>
		<select type="text" id="driverBranch" name="driverBranch" class="form-control">
		<option selected disabled>Select the Branch</option>
		  <option value="Galle">Galle</option>
		  <option value="Kandy">Kandy</option>
		  <option value="Nugegoda">Nugegoda</option>
		  <option value="Gampaha">Gampaha</option>
		  <option value="Kurunegala">Kurunegala</option>
		  <option value="Jaffna">Jaffna</option>
		</select>
		
		<label for="vehicleNumber">Enter Vehicle Number:</label>
		<input type="text" id="vehicleNumber" name="vehicleNumber" class="form-control"/>
		
		<label for="vehicleType">Enter Vehicle Type:</label>
		<input type="text" id="vehicleType" name="vehicleType" class="form-control"/>
		
		<input type="hidden" name="action" value="add"/>
		<br/>
		<button type="submit" class="btn btn-primary">Add Driver and Vehicle</button>
	</form>
</div>

</body>
</html>