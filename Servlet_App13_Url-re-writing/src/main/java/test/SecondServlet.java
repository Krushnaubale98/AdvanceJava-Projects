package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		pw.println("=====ProductDetails======<br>");
		pw.println("ProdCode: " + request.getParameter("pcode"));
		pw.println("<br>ProdName:" + request.getParameter("pname"));
		pw.println("<br>ProdPrice: " + request.getParameter("pprice"));
		pw.println("<br>ProdQty: " + request.getParameter("pqty") + "<br>");
		request.getRequestDispatcher("input.html").include(request, response);
		

	}

}
