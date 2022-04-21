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

<script>
function orderFunction() {
  alert("Product Added! Please go to the Orders Management to view your Order");
}
</script>
<br/>

<h1>Customer Products Home Page</h1>

<label><b> Account: ${user} </b></label>

	<p>${message}</p>
	<br/>
	
<div class="container">
	<h2>Search Orders: </h2>
	<br/>
	<form action="getCustomerProducts">
		<label for="productCode">Product Code: </label>
		<input id="productCode" name="productCode" type="number" class="form-control"/>
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
				<th>Product Code</th>
				<th>Product Name</th>
				<th>Product Description</th>
				<th>Product Price[LKR]</th>
			</tr>
		</thead>
		
		<tbody>
			<tag:forEach var="product" items="${productList}">
				<tr>
					<td>${product.getProductCode()}</td>
					<td>${product.getProductName()}</td>
					<td>${product.getProductDescription()}</td>
					<td>${product.getProductPrice()}</td>
					<td>
						<form action="orderProduct" method="post">
							<input type="hidden" name="action" value="order"/>
							<input type="hidden" name="productCode" value="${product.getProductCode()}"/>
							<input type="hidden" name="customerEmail" value="${user}"/>
							<button type="submit" class="btn btn-success" onclick="orderFunction()">Order</button> 
						</form>
					</td>
				</tr>
			</tag:forEach>
				<tr>
					<td><label for="productCode">${product.getProductCode()}</label></td>
					<td><label for="productName">${product.getProductName()}</label></td>
					<td><label for="productDescription">${product.getProductDescription()}</label></td>
					<td><label for="productSupplier">${product.getProductPrice()}</label></td>
				</tr>
		</tbody>
	</table>
</div>

</body>
</html>