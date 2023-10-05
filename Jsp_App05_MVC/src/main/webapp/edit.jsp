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
	%>
	<form action="update" method="post">
		Address:<input type="text" name="addr" value="<%=ub.getAddr()%>"><br>
		MailId :<input type="text" name="mid" value="<%=ub.getmId()%>"><br>
		PhNo :<input type="text" name="phno" value="<%=ub.getPhNo()%>"><br>
		<input type="submit" value="UpdateProfile">
	</form>
</body>
</html>