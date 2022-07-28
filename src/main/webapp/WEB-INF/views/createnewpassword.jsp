<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
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

<%if(request.getAttribute("exception")!=null){ %>
<p style="color: red"><%=request.getAttribute("exception") %></p>
<%} %>
<form action="updatepassword" method="post">

	<div class="form-group">
			<label >Your Email</label> <input
				type="email" class="form-control" name="email"
				value="<%=request.getAttribute("email") %>" readonly="readonly"/>
		</div>
		<div class="form-group">
			<label >Enter Your New Password</label> <input
				type="text" class="form-control" name="password"
				placeholder="Enter your new password" />
		</div>
		<div class="form-group">
			<label >Enter Your Password Again</label> <input
				type="text" class="form-control" name="passwordagain"
				placeholder="Enter password again" />
		</div>
		<%if(request.getAttribute("passwordmismatch")!=null){ %>
		<h1><%=request.getAttribute("passwordmismatch") %></h1>
		<%} %>
		<div class="text-center form-group">
			<input type="submit" value="Submit"/>
		</div>
</form>
</div>
</div>
</div>
</div>
</div>
</body>
</html>