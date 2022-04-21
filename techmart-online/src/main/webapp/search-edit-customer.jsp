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

<h1>Customer Management</h1>

<br/>
	<p>${message}</p>
<br/>

<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link" aria-current="page" href="add-customer.jsp">Add Customer</a>
  </li>
  <li class="nav-item active">
    <a class="nav-link" href="#">Search/Edit Customer</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="getCustomer?action=all">All Customers</a>
  </li>
</ul>
<br/>

<div class="container">
	<h2>Search a Customer: </h2>
	<br/>
	<form action="getCustomer">
		<label for="customerEmail">Customer Email: </label>
		<input id="customerEmail" name="customerEmail" type="email" class="form-control"/>
		<input type="hidden" name="action" value="single"/>
		<br/>
		<button type="submit" class="btn btn-info">Search</button>
	</form>
</div>

<br/>

<div class="container">
	<h2>Edit the Customer: </h2>
	<br/>
	<form action="updateCustomer" method="post">
		<label for="customerEmail">Customer Email:</label>
		<input id="customerEmail" readonly="readonly" name="customerEmail" type="email" class="form-control" value="${customer.getCustomerEmail()}"/>
		
		<label for="customerName">Customer Name:</label>
		<input id="customerName" name="customerName" type="text" class="form-control" value="${customer.getCustomerName()}"/>
		
		<label for="customerAddress">Customer Address:</label>
		<input id="customerAddress" name="customerAddress" type="text" class="form-control" value="${customer.getCustomerAddress()}"/>
		
		<label for="customerPassword">Customer Password:</label>
		<input id="customerPassword" readonly="readonly" name="customerPassword" type="password" class="form-control" value="${customer.getCustomerPassword()}"/>
		
		<label for="customerBranch">Customer Branch:</label>
		<select type="text" id="customerBranch" name="customerBranch" class="form-control" value="${customer.getCustomerBranch()}">
		<option selected>${customer.getCustomerBranch()}</option>
		  <option value="Galle">Galle</option>
		  <option value="Kandy">Kandy</option>
		  <option value="Nugegoda">Nugegoda</option>
		  <option value="Gampaha">Gampaha</option>
		  <option value="Kurunegala">Kurunegala</option>
		  <option value="Jaffna">Jaffna</option>
		</select>
		
		<label for="customerPaymentMethod">Customer Payment Method:</label>
		<select type="text" id="customerPaymentMethod" name="customerPaymentMethod" class="form-control" value="${customer.getCustomerPaymentMethod()}">
		<option selected>${customer.getCustomerPaymentMethod()}</option>
		  <option value="Cash on Delivery">Cash on Delivery</option>
		  <option value="Bank Transfers">Bank Transfers</option>
		</select>
		
		<input type="hidden" name="action" value="update"/>
		<br/>
		<button type="submit" class="btn btn-warning">Update</button>
	</form>
</div>

</body>
</html>