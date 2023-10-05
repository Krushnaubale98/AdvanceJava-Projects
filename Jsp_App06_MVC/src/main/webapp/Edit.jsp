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
	ProductBean pb = (ProductBean) session.getAttribute("pb");
		%>
		<form action="update" method="post">
		ProductPrice:<input type="number" name="pprice" value="<%=pb.getPrice() %>"><br>
		Product Qty:<input type="text" name="pqty" value="<%=pb.getQty() %>"><br>
		<input type="submit" value="UpdateProdcut"> <br><br>
		</form>
	</body>
</html>