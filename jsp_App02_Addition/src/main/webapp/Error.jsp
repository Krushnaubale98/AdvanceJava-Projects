<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	out.println("Enter only integer values...<br><br>");
	%>
	<%=exception%>

	<br>
	<%@include file="input.html"%>
</body>
</html>