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

<h1>CUSTOMER REGISTRATION</h1>

<br/>
	<p>${message}</p>
<br/>


<div class="container">
	<h2>Register: </h2>
	<br/>
	<form action="addCustomerRegister" method="post">
		<label for="customerEmail">Enter your Email</label>
		<input type="email" id="customerEmail" name="customerEmail" class="form-control" required/>
		
		<label for="customerName">Enter your Name:</label>
		<input type="text" id="customerName" name="customerName" class="form-control" required/>
		
		<label for="customerAddress">Enter your Address:</label>
		<input type="text" id="customerAddress" name="customerAddress" class="form-control" required/>
		
		<label for="customerPassword">Enter your Password:</label>
		<input type="password" id="customerPassword" name="customerPassword" class="form-control" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required/>
		
		<label for="customerBranch">Enter your Nearest Branch:</label>	
		<select type="text" id="customerBranch" name="customerBranch" class="form-control" required>
		<option selected disabled>Select the Branch</option>
		  <option value="Galle">Galle</option>
		  <option value="Kandy">Kandy</option>
		  <option value="Nugegoda">Nugegoda</option>
		  <option value="Gampaha">Gampaha</option>
		  <option value="Kurunegala">Kurunegala</option>
		  <option value="Jaffna">Jaffna</option>
		</select>
		
		<label for="customerPaymentMethod">Enter the Payment Method:</label>
		<select type="text" id="customerPaymentMethod" name="customerPaymentMethod" class="form-control" required>
		<option selected disabled>Select the Payment Method</option>
		  <option value="Cash on Delivery">Cash on Delivery</option>
		  <option value="Bank Transfers">Bank Transfers</option>
		</select>
		
		<input type="hidden" name="action" value="add"/>
		<br/>	
		<div id="loginLink">
      			<a class="underlineHover" href="http://localhost:8080/techmart-online/customer-login.jsp">Already Registered? LOGIN</a>
    	</div>
    	<br/>
		<button type="submit" class="btn btn-primary">Register</button>
	</form>
</div>

</body>
</html>