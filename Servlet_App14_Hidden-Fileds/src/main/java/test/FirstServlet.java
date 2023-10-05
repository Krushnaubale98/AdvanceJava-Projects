package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@SuppressWarnings("serial")
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		ProductBean pb = new RetrieveDao().retrieve(request);

		if (pb == null) {
			pw.println("Invalid productCode..<br><br>");
			request.getRequestDispatcher("input.html").include(request, response);
		} else {
			pw.println("<form action='second'>");
			pw.println("<input type='hidden' name='pcode' value='" + pb.getPname() + "'>");
			pw.println("<input type='hidden' name='pprice' value='" + pb.getPprice() + "'>");
			pw.println("<input type='hidden' name='pqty' value=' " + pb.getPqty() + "'>");
			pw.println("<input type='submit' value='ViewProductDetails'>");
			pw.println("</form>");

		}
	}

}
