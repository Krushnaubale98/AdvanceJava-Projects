<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	int v1 = Integer.parseInt(request.getParameter("v1"));
	int v2 = Integer.parseInt(request.getParameter("v2"));

	int v4 = Integer.parseInt(request.getParameter("v4"));
	int v3 = v1 + v2;
	out.println("Sub=" + v3 + "<br>");
	out.println("Param value: " + v4 + "<br>");
	%>
	<jsp:include page="input.html"></jsp:include>
</body>
</html>