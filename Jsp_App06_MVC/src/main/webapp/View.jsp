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
	out.println(ub.getfName() + "&nbsp&nbsp&nbsp" + ub.getlName() + "&nbsp&nbsp&nbsp" + ub.getAddr() + "&nbsp&nbsp&nbsp"
			+ ub.getmId() + "&nbsp&nbsp&nbsp" + ub.getPhNo() + "<br><br><br>");
	String s1 = (String) application.getAttribute("logintype");
	if (s1.equals("UserLogin")) {
	%>
	<jsp:include page="Link1.html" />
	<%
	} else {
	%>
	<jsp:include page="Link2.html" />
	<%
	}
	%>

</body>
</html>