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

<h1>Customer Management</h1>
<br/>
<br/>
<p>${message}</p>
<p>${deleteMessage}</p>
<br/>

<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link" aria-current="page" href="add-customer.jsp">Add Customer</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="search-edit-customer.jsp">Search/Edit Customer</a>
  </li>
  <li class="nav-item">
    <a class="nav-link active" href="#">All Customers</a>
  </li>
</ul>
<br/>

<div class="container">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Customer Email</th>
				<th>Customer Name</th>
				<th>Customer Address</th>
				<th>Customer Password</th>
				<th>Customer Branch</th>
				<th>Payment Method</th>
			</tr>
		</thead>
		
		<tbody>
			<tag:forEach var="customer" items="${customerList}">
				<tr>
					<td>${customer.getCustomerEmail()}</td>
					<td>${customer.getCustomerName()}</td>
					<td>${customer.getCustomerAddress()}</td>
					<td>${customer.getCustomerPassword()}</td>
					<td>${customer.getCustomerBranch()}</td>
					<td>${customer.getCustomerPaymentMethod()}</td>
					<td>
						<form action="deleteCustomer" method="post">
							<input type="hidden" name="action" value="delete"/>
							<input type="hidden" name="customerEmail" value="${customer.getCustomerEmail()}"/>
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