<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot Password</title>
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
<form action="getotp" method="post">


	<div class="form-group">
			<label >Enter Your Email</label> <input
				type="email" class="form-control" name="email"
				placeholder="Enter your email" />
		</div>
		<div class="text-center form-group">
			<input type="submit" value="Get OTP"/>
		</div>
</form>	<%if(request.getAttribute("message")!=null){ %>
<h6 style="color: red"><%=request.getAttribute("message") %></h6>
<%} %>

<form action="submitotp" method="post">
<%if(request.getAttribute("email")!=null){ %>
	<input type="number" name="otp" value="<%=request.getAttribute("otp") %>" hidden="hidden"/>
	<input type="text" name="email" value="<%=request.getAttribute("email") %>" hidden="hidden"/>
	<% }%>	
		<div class="form-group">
			<label >Enter OTP </label> <input
				type="number" class="form-control" name="enteredotp"
				placeholder="Enter otp" required="required">
		</div>
		<%if(request.getAttribute("otpsent")!=null){ %>
		<div class="text-center form-group">
			<input type="submit" value="Create New Password"/>
		</div>
		<%} %>
</form>		
</div>
</div>
</div>
</div>
</div>
</body>
</html>