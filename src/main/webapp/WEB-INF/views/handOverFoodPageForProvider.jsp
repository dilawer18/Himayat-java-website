<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OTP Verification</title>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container mt-4 ">
<div class="row">
<div class="col-sm-6 offset-md-3">
<div class="card">
<div class="card-body">
<h3 class="text-center"> Login</h3>

<form action="submitOtpToHandoverFood" method="post">

	<%if(request.getAttribute("message")!=null){ %>
	<p style="color: red;"><%=request.getAttribute("message") %></p>
	<%} %>
	<div class="form-group">
			<label >Enter Receiver's Email</label> <input
				type="email" class="form-control" name="email"
				placeholder="Enter email" required="required">
		</div>
		<div class="form-group">
			<label >Ask OTP and Enter</label> <input
				type="text" class="form-control" name="otp"
				placeholder="Enter OTP" required="required" >
		</div>
		
		
		
		<div class="text-center form-group">
			<input type="submit" value="Submit OTP"/>
		</div>

</form>
</div>
</div>
</div>
</div>
</div>

</body>
</html>