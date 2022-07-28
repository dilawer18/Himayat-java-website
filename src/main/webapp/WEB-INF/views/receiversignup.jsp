<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	<h3 class="text-center"> SignUp Form</h3>
	<form action="formsubmit" method="post">
	<input type="number" value="1" readonly="readonly" hidden="hidden" name="providerId"/>
	<div class="form-group">
			<label >Name</label> <input
				type="text" class="form-control" name="providerName"
				placeholder="Enter your name" required="required">
		</div>
	
		<div class="form-group">
			<label >Phone Number</label> <input
				type="number" class="form-control" name="phone"
				placeholder="Enter your phone number" required="required">
		</div>
	
		<div class="form-group">
			<label >Email address</label> <input
				type="email" class="form-control" name="email"
				placeholder="name@example.com" required="required">
		</div>
	
	
		<div class="form-group">
			<label >Select Your City</label> <select
				class="form-control" name="city" required="required">
				<option>Chandigarh</option>
			</select>
		</div>
		<div class="form-group">
			<label >Select Your Area</label> <select  class="form-control"
				name="cityArea" required="required">
				<option>sector 34</option>
				<option>sector 22</option>
				<option>sector 17</option>
				<option>sector 43</option>
				<option>Dera Bassi</option>
				<option>Mohali</option>
			</select>
		</div>
		
		<div class="form-group">
			<label >Your Address</label>
			<textarea class="form-control" name="address"
				rows="3"></textarea>
		</div>
		
		<div class="form-group">
			<label >Type of Receiver</label> <select  class="form-control"
				name="typeOfUser" required="required">
				<option>NGO</option>
				<option>Social Worker</option>
				
			</select>
		</div>
		<input type="text" name="type" value="receiver" hidden="hidden"/>
		
		
		<div class="form-group">
			<label >Password <%out.print("(minumum length of 8 characters)"); %></label>
			<textarea class="form-control" name="password"
				rows="1" required="required" minlength="8"></textarea>
		</div>
		<%if(request.getAttribute("message")!=null){ %>
		<div>
		<p style="color: red"><%=request.getAttribute("message") %> </p>
		</div>
		<%} %>
		<div class="form-group">
			<label >Type your password again</label>
			<textarea class="form-control" name="passwordagain"
				rows="1" required="required" minlength="8" ></textarea>
		</div>
		
		
		<div class="text-center form-group">
			<input type="submit" value="submit"/>
		</div>
	</form>
	</div>
	</div>
	</div>
	</div>
	</div>


</body>
</html>