<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://unpkg.com/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
<title>TechMart Online</title>
<style>
label {display: block;
    text-align: center;
	font-size: 150px;
}
</style>
</head>

<body style="background-color:#31906E;">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand">&emsp; TechMart Admin &emsp;&emsp;</a>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="http://localhost:8080/techmart-online/welcome-techmart.jsp">Home &emsp;<span class="sr-only"></span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="http://localhost:8080/techmart-online/getProducts?action=all">Products Inventory Management &emsp;<span class="sr-only"></span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="http://localhost:8080/techmart-online/getSalesAgents?action=all">Sales Agent Management &emsp;<span class="sr-only"></span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="http://localhost:8080/techmart-online/getCustomer?action=all">Customer Management &emsp;<span class="sr-only"></span></a>
      </li>
            <li class="nav-item active">
        <a class="nav-link" href="http://localhost:8080/techmart-online/getDelivery?action=all">Delivery Driver and Vehicle Management &emsp;<span class="sr-only"></span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="http://localhost:8080/techmart-online/getOrders?action=all">Orders Management &emsp;<span class="sr-only"></span></a>
      </li>
    </ul>
  </div>
</nav>

<br/><br/><br/><br/><br/><br/><br/>
<label><font face="Comic sans MS" color="#50C878"><b>TechMart Admin</b></font></label>

</body>
</html>