<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*,test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	try {
		ResultSet rs = new RetrieveDao().retrieve(request);
		if (rs.next()) {
	%>
	<jsp:useBean id="ob" class="test.BookBean" scope="session" />
	<jsp:setProperty property="bCode" name="ob"
		value="<%=rs.getString(1)%>" />
	<jsp:setProperty property="bName" name="ob"
		value="<%=rs.getString(2)%>" />
	<jsp:setProperty property="bAuthor" name="ob"
		value="<%=rs.getString(3)%>" />
	<jsp:setProperty property="bPrice" name="ob"
		value="<%=rs.getFloat(4)%>" />
	<jsp:setProperty property="bQty" name="ob" value="<%=rs.getInt(5)%>" />
	<%
	out.println("Data retrieved to Bean Object ...<br>");

	} else {
	out.println("Invalid BookCode....<br><br>");
	%>
	<jsp:include page="input.html" />
	<%
	}
	} catch (Exception e) {
	e.printStackTrace();
	}
	%>

	<a href="Display.jsp">ViewDetails</a>
</body>
</html>