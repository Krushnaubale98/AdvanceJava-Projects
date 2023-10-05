<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="n" value="${param.str}" />
	<c:forEach var="j" begin="1" end="5">
		<c:out value="${n}" />
		<p>
	</c:forEach>

	<c:forTokens items="${param.str}" delims=" " var="name">
		<c:out value="${name}" />
		<p>
	</c:forTokens>
</body>
</html>