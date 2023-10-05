<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String s1 = request.getParameter("s1");
	if (s1.equals("Add")) {
	%>
	<jsp:forward page="Addition.jsp">
		<jsp:param value="<%=200%>" name="v4" />
	</jsp:forward>
	<%
	} else {
	%>
	<jsp:forward page="Subtraction.jsp">
		<jsp:param value="<%=300%>" name="v4" />
	</jsp:forward>
	<%
	}
	%>
</body>
</html>