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
	String s1 = (String) application.getAttribute("logintype");
	if (s1.equals("UserLogin")) {
		out.println("Welcome User " + ub.getfName() + "<br><br>");
	%>
	<jsp:include page="Link1.html" />
	<%
	} else {
	out.println("welcome Admin " + ub.getfName() + "<br><BR>");
	%>
	<jsp:include page="Link2.html" />
	<%
	}
	%>

</body>
</html>