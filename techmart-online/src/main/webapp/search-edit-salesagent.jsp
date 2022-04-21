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
    <a class="nav-link" aria-current="page" href="add-salesagent.jsp">Add Sales Agent</a>
  </li>
  <li class="nav-item active">
    <a class="nav-link" href="#">Search/Edit Sales Agent</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="getSalesAgents?action=all">All Sales Agent</a>
  </li>
</ul>
<br/>

<div class="container">
	<h2>Search a Sales Agent: </h2>
	<br/>
	<form action="getSalesAgents">
		<label for="salesAgentId">Sales Agent ID: </label>
		<input id="salesAgentId" name="salesAgentId" type="number" class="form-control"/>
		<input type="hidden" name="action" value="single"/>
		<br/>
		<button type="submit" class="btn btn-info">Search</button>
	</form>
</div>

<br/>

<div class="container">
	<h2>Edit the Sales Agent: </h2>
	<br/>
	<form action="updateSalesAgent" method="post">
		<label for="salesAgentId">Sales Agent ID:</label>
		<input id="salesAgentId" readonly="readonly" name="salesAgentId" type="number" class="form-control" value="${salesagent.getSalesAgentId()}"/>
		
		<label for="salesAgentName">Sales Agent Name:</label>
		<input id="salesAgentName" name="salesAgentName" type="text" class="form-control" value="${salesagent.getSalesAgentName()}"/>
		
		<label for="salesAgentBranch">Sales Agent Branch:</label>
		<br/>
		<select type="text" id="salesAgentBranch" name="salesAgentBranch" class="form-control" value="${salesagent.getSalesAgentBranch()}">
		<option selected>${salesagent.getSalesAgentBranch()}</option>
		  <option value="Galle">Galle</option>
		  <option value="Kandy">Kandy</option>
		  <option value="Nugegoda">Nugegoda</option>
		  <option value="Gampaha">Gampaha</option>
		  <option value="Kurunegala">Kurunegala</option>
		  <option value="Jaffna">Jaffna</option>
		</select>
		
		<label for="salesAgentPassword">Sales Agent Password:</label>
		<input id="salesAgentPassword" name="salesAgentPassword" type="password" class="form-control" value="${salesagent.getSalesAgentPassword()}"/>
		<input type="hidden" name="action" value="update"/>
		<br/>
		<button type="submit" class="btn btn-warning">Update</button>
	</form>
</div>

</body>
</html>