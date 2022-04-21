<%@page import="java.util.ArrayList"%>
<%@page import="com.themiya.techmartonline.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TechMart Online</title>
</head>
<body>
	<h1>Welcome to TechMart Online</h1>
	<br/>
	<br/>
	<p>
		<%
			out.println(request.getAttribute("message"));
		%>
	</p>
	<br/>
	<br/>
	<table>
		<thead>
			<tr>
				<th>Product Code</th>
				<th>Product Name</th>
				<th>Product Price</th>
			</tr>
		</thead>
			<%
			List<Product> products = (ArrayList<Product>)request.getAttribute("productList");
			
			for(Product p : products) {
			out.println("<tr>");
			out.println("<td>"+ p.getProductCode() + "</td>");
			out.println("<td>" + p.getProductName() + "</td>");
			out.println("<td>" + p.getProductPrice() + "</td");
			out.println("</tr>");
			}
			%>
		<tbody>
		
		</tbody>
	</table>
</body>
</html>