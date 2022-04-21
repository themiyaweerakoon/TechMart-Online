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

<h1>Products Inventory Management</h1>

<br/>
	<p>${message}</p>
<br/>

<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link active" aria-current="page" href="#">Add Product</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="search-edit-product.jsp">Search/Edit Product</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="getProducts?action=all">All Products</a>
  </li>
</ul>

<br/>

<div class="container">
	<h2>Add a Product: </h2>
	<br/>
	<form action="addProduct" method="post">
		<label for="productCode">Enter Product Code:</label>
		<input type="number" id="productCode" name="productCode" class="form-control"/>
		
		<label for="productName">Enter Product Name:</label>
		<input type="text" id="productName" name="productName" class="form-control"/>
		
		<label for="productDescription">Enter Product Description:</label>
		<input type="text" id="productDescription" name="productDescription" class="form-control"/>
		
		<label for="productPrice">Enter Product Price[LKR]:</label>
		<input type="number" id="productPrice" name="productPrice" class="form-control"/>
		
		<label for="productQuantity">Enter Product Quantity:</label>
		<input type="number" id="productQuantity" name="productQuantity" class="form-control"/>
		
		<label for="productSupplier">Enter Product Supplier:</label>
		<input type="text" id="productSupplier" name="productSupplier" class="form-control"/>
		
		<label for="productStock">Enter Stock Quantity that needs:</label>
		<input type="number" id="productStock" name="productStock" class="form-control"/>
		<input type="hidden" name="action" value="add"/>
		<br/>
		<button type="submit" class="btn btn-primary">Add Product</button>
	</form>
</div>

</body>
</html>