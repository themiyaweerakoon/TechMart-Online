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
  <a class="navbar-brand">&emsp; Customer Dashboard &emsp;&emsp;</a>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link">Hello, ${user} ! Welcome to your Profile! &emsp;<span class="sr-only"></span></a>
      </li>
      <li class="nav-item active">
        <form action="getLogout" method="post">
		<button class=" btn btn-danger btn-sm btn-block">Logout</button></form>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="http://localhost:8080/techmart-online/getCustomerProducts?action=all">&emsp; View All Products &emsp;<span class="sr-only"></span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="http://localhost:8080/techmart-online/getCustomerOrderUpdate?action=all">&emsp; Order Management &emsp;<span class="sr-only"></span></a>
      </li>
    </ul>
  </div>
</nav>

	<p>${message}</p>

<br/><br/><br/><br/><br/>
<label><font face="Comic sans MS" color="#50C878"><b>Customer Dashboard</b></font></label>

</body>
</html>