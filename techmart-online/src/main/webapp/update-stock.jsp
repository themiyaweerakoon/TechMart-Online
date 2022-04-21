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

<h1>Stock Management</h1>

<br/>
	<p>${message}</p>
<br/>

<ul class="nav nav-tabs">
  <li class="nav-item active">
    <a class="nav-link" href="#">Update Stock</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="getStock?action=all">All Stock</a>
  </li>
</ul>
<br/>

<div class="container">
	<h2>Search a Product: </h2>
	<br/>
	<form action="getStock">
		<label for="productCode">Product Code: </label>
		<input id="productCode" name="productCode" type="number" class="form-control"/>
		<input type="hidden" name="action" value="single"/>
		<br/>
		<button type="submit" class="btn btn-info">Search</button>
	</form>
</div>

<br/>

<div class="container">
	<h2>Update the Stock: </h2>
	<br/>
	<form action="updateStock" method="post">
		<label for="productCode">Product Code:</label>
		<input id="productCode" readonly="readonly" name="productCode" type="number" class="form-control" value="${product.getProductCode()}"/>
		
		<label for="productName">Product Name:</label>
		<input id="productName" readonly="readonly" name="productName" type="text" class="form-control" value="${product.getProductName()}"/>
		
		<label for="productDescription">Product Description:</label>
		<input id="productDescription" readonly="readonly" name="productDescription" type="text" class="form-control" value="${product.getProductDescription()}"/>
		
		<label for="productPrice">Product Price[LKR]:</label>
		<input id="productPrice" readonly="readonly" name="productPrice" type="number" class="form-control" value="${product.getProductPrice()}"/>
		
		<label for="productQuantity">Product Quantity:</label>
		<input id="productQuantity" readonly="readonly" name="productQuantity" type="number" class="form-control" value="${product.getProductQuantity()}"/>
		
		<label for="productSupplier">Product Supplier:</label>
		<input id="productSupplier" readonly="readonly" name="productSupplier" type="text" class="form-control" value="${product.getProductSupplier()}"/>
		
		<label for="productStock">Enter Stock Quantity that needs:</label>
		<input id="productStock" name="productStock" type="number" class="form-control" value="${product.getProductStock()}"/>
		<input type="hidden" name="action" value="update"/>
		<br/>
		<button type="submit" class="btn btn-warning">Update</button>
	</form>
</div>

</body>
</html>