<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!int add;

	public int addition(int val1, int val2) {
		add = val1 + val2;
		return add;
	}%>

	<%
	int value1 = Integer.parseInt(request.getParameter("val1"));
	int value2 = Integer.parseInt(request.getParameter("val2"));

	int result = addition(value1, value2);
	out.println("Addtion add: " + result);
	%>

	<%@ include file="input.html"%>

</body>
</html>