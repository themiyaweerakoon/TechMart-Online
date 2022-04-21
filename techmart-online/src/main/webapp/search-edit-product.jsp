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
    <a class="nav-link" aria-current="page" href="add-product.jsp">Add Product</a>
  </li>
  <li class="nav-item active">
    <a class="nav-link" href="#">Search/Edit Product</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="getProducts?action=all">All Products</a>
  </li>
</ul>
<br/>

<div class="container">
	<h2>Search a Product: </h2>
	<br/>
	<form action="getProducts">
		<label for="productCode">Product Code: </label>
		<input id="productCode" name="productCode" type="number" class="form-control"/>
		<input type="hidden" name="action" value="single"/>
		<br/>
		<button type="submit" class="btn btn-info">Search</button>
	</form>
</div>

<br/>

<div class="container">
	<h2>Edit the Product: </h2>
	<br/>
	<form action="updateProduct" method="post">
		<label for="productCode">Product Code:</label>
		<input id="productCode" readonly="readonly" name="productCode" type="number" class="form-control" value="${product.getProductCode()}"/>
		
		<label for="productName">Product Name:</label>
		<input id="productName" name="productName" type="text" class="form-control" value="${product.getProductName()}"/>
		
		<label for="productDescription">Product Description:</label>
		<input id="productDescription" name="productDescription" type="text" class="form-control" value="${product.getProductDescription()}"/>
		
		<label for="productPrice">Product Price[LKR]:</label>
		<input id="productPrice" name="productPrice" type="number" class="form-control" value="${product.getProductPrice()}"/>
		
		<label for="productQuantity">Product Quantity:</label>
		<input id="productQuantity" name="productQuantity" type="number" class="form-control" value="${product.getProductQuantity()}"/>
		
		<label for="productSupplier">Product Supplier:</label>
		<input id="productSupplier" name="productSupplier" type="text" class="form-control" value="${product.getProductSupplier()}"/>
		
		<label for="productStock">Stock Quantity that needs:</label>
		<input id="productStock" readonly="readonly" name="productStock" type="number" class="form-control" value="${product.getProductStock()}"/>
		<input type="hidden" name="action" value="update"/>
		<br/>
		<button type="submit" class="btn btn-warning">Update</button>
	</form>
</div>

</body>
</html>