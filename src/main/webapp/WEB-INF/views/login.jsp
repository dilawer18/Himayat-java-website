<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body style="background: #e2e2e2;">
<%@include file="navbar.jsp" %>
<div class="container mt-4 ">
<div class="row">
<div class="col-sm-6 offset-md-3">
<div class="card">
<div class="card-body">
<h3 class="text-center"> Login</h3>
<% if(request.getAttribute("message")!=null){ %>
<p style="color: green"> <%=request.getAttribute("message") %></p>
<%} %>
<%-- <img style="height: 30px;width: 30px" alt="" src='<c:url value="/resources/img/IMG_20210910_160331.jpg" />'> --%>

<form action="logindata" method="post">


	<div class="form-group">
			<label >Enter Your Email</label> <input
				type="email" class="form-control" name="email"
				placeholder="Enter your email" required="required">
		</div>
		<div class="form-group">
			<label >Enter Your Password</label> <input
				type="text" class="form-control" name="password"
				placeholder="Enter your password" required="required" minlength="8">
		</div>
		
		
		<div class="form-group">
			<label >Type of User</label> <select  class="form-control"
				name="type" required="required">
				<option>Receiver</option>
				<option>Donor</option>
			</select>
		</div>
		
		
		<div class="text-center form-group">
			<input type="submit" value="submit"/>
		</div>
		
		<div class="text-right form-group">
			<a href="forgotpasswordrequest">forgot password?</a>
		</div>

</form>
</div>
</div>
</div>
</div>
</div>
</body>
</html>