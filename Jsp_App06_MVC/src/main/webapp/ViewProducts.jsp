<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="test.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	UserBean ub = (UserBean) session.getAttribute("ubean");
	ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("al");
	out.println("Page of " + ub.getfName() + "<br><br>");
	if (al.size() == 0) {
		out.println("<br>Products not available ....<br><br>");
	} else {
		Iterator<ProductBean> it = al.iterator();
		while (it.hasNext()) {
			ProductBean pb = (ProductBean) it.next();
			out.println("<br>"+  pb.getCode() + "&nbsp&nbsp" + pb.getName() + "&nbsp&nbsp" + pb.getPrice() + "&nbsp&nbsp"
			+ pb.getQty() + "<br>");

		} //end of while
	} //end of else

	String s1 = (String) application.getAttribute("logintype");
	if (s1.equals("UserLogin")) {
	%>
	<jsp:include page="Link1.html" />
	<%
	} else {
	%>
	<jsp:include page="Link2.html"></jsp:include>
	<%
	}
	%>
</body>
</html>