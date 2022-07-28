<%@page import="java.util.List"%>
<%@page import="com.donate.beans.FoodUnit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Select an unit</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body style="background: #e2e2e2;">
<%@include file="navbar.jsp" %>
<div class="container mt-4">
<div class="row">
<div class="col-md-6 offset-md-3">
<div class="card">
<div class="card-body">
<%List<FoodUnit> foods = (List)request.getAttribute("foods"); 
%>
<%! int sno = 1; %>
<div class="container mt-3">
	<div class="row">
		<div class="col-md-12">
			<h1 class="text-center mb-3"> Select an Unit</h1>
			
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Sno</th>
						<th scope="col">Serves</th>
						<th scope="col">items</th>
						<th scope="col">Address</th>
						<th scope="col">Phone </th>
						<th scope="col">Select</th>
					</tr>
				</thead>
				<tbody>
				<tr><%sno = 1; %>
				<% for(FoodUnit unit : foods) {%>
					
						<td scope="row"><%=sno++ %></td>
						<td scope="row"><%= unit.getServes() %></td>
						<td scope="row"><%=unit.getItems() %></td>
						<td scope="row"><%= unit.getAddress() %></td>
						<td scope="row"><%=unit.getContactNumber() %></td>
						<%long cn = unit.getContactNumber(); %>
						<td><a href="get/<%=cn%>">Get</a></td>
						
					</tr>
				<%} %>
				</tbody>
			
			</table>
			
			
			
			</div>
		
		</div>
	
	</div>


</div>
</div>
</div>
</div>
</div>



</body>
</html>