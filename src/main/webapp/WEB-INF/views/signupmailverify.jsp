<%@page import="org.hibernate.Hibernate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mail Verification</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body class="" style="background: #e2e2e2;">
<%@include file="navbar.jsp" %>
<div class="card">
<div class="card-body">
<form action="addprovider" method="post">
	<div class="form-group">
			<label >Your Email</label> <input
				type="email" class="form-control" name="email"
				value="<%=request.getAttribute("email") %>" readonly="readonly"/>
		</div>
		<div class="form-group">
			<label >Enter OTP </label> <input
				type="number" class="form-control" name="enteredotp"
				placeholder="Enter otp" required="required">
		</div>
		<%if(request.getAttribute("otpmismatch")!=null){ %>
		<h1><%=request.getAttribute("otpmismatch") %></h1>
		<%} %>
		<div class="text-center form-group">
			<input type="submit" value="Submit OTP"/>
		</div>
	
		
</form>	
</div>
</div>
</body>
</html>