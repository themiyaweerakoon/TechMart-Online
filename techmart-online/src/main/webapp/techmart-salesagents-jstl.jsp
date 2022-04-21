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

<br/>

<h1>Sales Agent Management</h1>
<br/>
<br/>
<p>${message}</p>
<p>${deleteMessage}</p>
<br/>

<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link" aria-current="page" href="add-salesagent.jsp">Add Sales Agent</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="search-edit-salesagent.jsp">Search/Edit Sales Agent</a>
  </li>
  <li class="nav-item">
    <a class="nav-link active" href="#">All Sales Agents</a>
  </li>
</ul>
<br/>

<div class="container">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Sales Agent ID</th>
				<th>Sales Agent Name</th>
				<th>Branch of the Sales Agent</th>
				<th>Sales Agent Password</th>
			</tr>
		</thead>
		
		<tbody>
			<tag:forEach var="salesagent" items="${salesAgentList}">
				<tr>
					<td>${salesagent.getSalesAgentId()}</td>
					<td>${salesagent.getSalesAgentName()}</td>
					<td>${salesagent.getSalesAgentBranch()}</td>
					<td>${salesagent.getSalesAgentPassword()}</td>
					<td>
						<form action="deleteSalesAgent" method="post">
							<input type="hidden" name="action" value="delete"/>
							<input type="hidden" name="salesAgentId" value="${salesagent.getSalesAgentId()}"/>
							<button type="submit" class="btn btn-danger">Delete</button> 
						</form>
					</td>
				</tr>
			</tag:forEach>
		</tbody>
	</table>
</div>

</body>
</html>