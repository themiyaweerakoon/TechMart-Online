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

<h1>Stock Management</h1>
<br/>
<br/>
<p>${message}</p>
<p>${deleteMessage}</p>
<br/>

<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link" href="update-stock.jsp">Update Stock</a>
  </li>
  <li class="nav-item">
    <a class="nav-link active" href="#">All Stock</a>
  </li>
</ul>
<br/>

<div class="container">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Product Code</th>
				<th>Product Name</th>
				<th>Product Description</th>
				<th>Product Price[LKR]</th>
				<th>Product Quantity</th>
				<th>Product Supplier</th>
				<th>Stock that Needs</th>
			</tr>
		</thead>
		
		<tbody>
			<tag:forEach var="product" items="${productList}">
				<tr>
					<td>${product.getProductCode()}</td>
					<td>${product.getProductName()}</td>
					<td>${product.getProductDescription()}</td>
					<td>${product.getProductPrice()}</td>
					<td>${product.getProductQuantity()}</td>
					<td>${product.getProductSupplier()}</td>
					<td>${product.getProductStock()}</td>
				</tr>
			</tag:forEach>
		</tbody>
	</table>
</div>

</body>
</html>