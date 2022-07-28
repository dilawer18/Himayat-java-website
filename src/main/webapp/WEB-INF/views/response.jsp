<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thank You:)</title>
</head>
<body>
<%@include file="navbar.jsp" %>
<h4 style="color: blue;"><%=request.getAttribute("message") %></h4>
</body>
</html>