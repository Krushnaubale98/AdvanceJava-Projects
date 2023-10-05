package test;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class Get and UpdateProductServlet
 */
@SuppressWarnings("serial")
@WebServlet("/getbycode")
public class GetByCodeProductServlet extends GenericServlet implements Servlet {

	public GetByCodeDao gd = null;
	public void init() throws ServletException {
		gd = new GetByCodeDao();
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		
		ProductBean pb = gd.getbyid(request.getParameter("pcode"));

		if (pb.equals("pcode") ) {
			pw.println("Invalid ProductCode...<Br>");
			request.getRequestDispatcher("bycode.html").include(request, response);

		} else {

			pw.println(pb.getCode() + "&nbsp&nbsp&nbsp" + pb.getName() + "&nbsp&nbsp&nbsp" + pb.getPrice()
					+ "&nbsp&nbsp&nbsp" + pb.getQty() +"<br><br><br>" );

		}
		request.getRequestDispatcher("bycode.html").include(request, response);

	}

}
