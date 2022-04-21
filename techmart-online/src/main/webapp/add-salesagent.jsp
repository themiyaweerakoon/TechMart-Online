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

<h1>Sales Agent Management</h1>

<br/>
	<p>${message}</p>
<br/>

<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link active" aria-current="page" href="#">Add Sales Agent</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="search-edit-salesagent.jsp">Search/Edit Sales Agent</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="getSalesAgents?action=all">All Sales Agents</a>
  </li>
</ul>

<br/>

<div class="container">
	<h2>Add a Sales Agent: </h2>
	<br/>
	<form action="addSalesAgent" method="post">
		
		<label for="salesAgentName">Enter Sales Agent Name:</label>
		<input type="text" id="salesAgentName" name="salesAgentName" class="form-control"/>
		
		<label for="salesAgentBranch">Select the Branch of the Sales Agent:</label>
		<br/>
		<select type="text" id="salesAgentBranch" name="salesAgentBranch" class="form-control">
		<option selected disabled>Select the Branch</option>
		  <option value="Galle">Galle</option>
		  <option value="Kandy">Kandy</option>
		  <option value="Nugegoda">Nugegoda</option>
		  <option value="Gampaha">Gampaha</option>
		  <option value="Kurunegala">Kurunegala</option>
		  <option value="Jaffna">Jaffna</option>
		</select>
		
		<label for="salesAgentPassword">Enter Sales Agent Password:</label>
		<input type="password" id="salesAgentPassword" name="salesAgentPassword" class="form-control"/>
		<input type="hidden" name="action" value="add"/>
		<br/>
		<button type="submit" class="btn btn-primary">Add Sales Agent</button>
	</form>
</div>

</body>
</html>