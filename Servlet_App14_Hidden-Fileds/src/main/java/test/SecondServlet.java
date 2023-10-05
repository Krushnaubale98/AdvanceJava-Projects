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
@SuppressWarnings("serial")
@WebServlet("/second")
public class SecondServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		pw.println("======ProductDetails======");
		pw.println("<br><br>ProdctCode: " + request.getParameter("pcode"));
		pw.println("<br>ProductName: " + request.getParameter("pname"));
		pw.println("<br>ProductPrice: " + request.getParameter("pprice"));
		pw.println("<br>ProductQty: " + request.getParameter("pqty"));

		request.getRequestDispatcher("input.html").include(request, response);

	}

}
