<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	UserBean ub = (UserBean) session.getAttribute("ubean");
	out.println("page of " + ub.getfName() + "<br><br>");
	out.println("Invalid ProductCode...<br>");
	%>
	<jsp:include page="Link2.html"/>
</body>
</html>