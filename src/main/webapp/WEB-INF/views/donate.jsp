<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Donate Food</title>
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
<a href="handover">HandOverFood</a>
	<h3 class="text-center"> Please Provide Few Information</h3>
	<form action="addunitfood" method="post">
	
	<div class="form-group">
			<label >Name</label> <input
				type="text" class="form-control" name="name"
				placeholder="Enter your name" required="required">
		</div>
	
		<div class="form-group">
			<label >Estimated Quantity(serves)</label> <input
				type="number" class="form-control" name="serves"
				placeholder="serves quantity" required="required">
		</div>
		
		<div class="form-group">
			<label >Type of items</label> <input
				type="number" class="form-control" name="items"
				placeholder="number of items" required="required">
		</div>
		<div class="form-group">
			<label >Availability(in hours)</label> <input
				type="number" class="form-control" name="hours"
				placeholder="in hours" required="required">
		</div>
	
	
		<div class="form-group">
			<label >Contact Number</label> <input
				type="number" class="form-control" name="phone"
				placeholder="Enter your phone number" required="required">
		</div>
		
		
		
		<div class="form-group">
			<label >Address</label>
			<textarea class="form-control" name="address"
				rows="3"></textarea>
		</div>
		
			<div class="form-group">
			<label >Landmark</label>
			<textarea class="form-control" name="landmark"
				rows="1"></textarea>
		</div>
		<div class="text-center form-group">
			<input type="submit" value="Donate"/>
		</div>
	</form>
	</div>
	</div>
	</div>
	</div>
	</div>




</body>
</html>