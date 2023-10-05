<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="ob" type="test.BookBean" scope="session"/>
BookCode: <jsp:getProperty property="bCode" name="ob"/><br>
BookName: <jsp:getProperty property="bName" name="ob"/><br>
BookAuthor:<jsp:getProperty property="bAuthor" name="ob"/><br>
BookPrice :<jsp:getProperty property="bPrice" name="ob"/><br>
BookQty :<jsp:getProperty property="bQty" name="ob"/><br>

</body>
</html>