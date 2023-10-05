package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class AddtionServlet
 */
@WebServlet("/add")
public class AddtionServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		try {
			int v1 = Integer.parseInt(request.getParameter("v1"));
			int v2 = Integer.parseInt(request.getParameter("v2"));
			
			int v3 = v1 + v2;
			pw.println("Sum: " + v3 + "<br>");

		} catch (Exception e) {
			//	e.printStackTrace();
			pw.println("Enter the only integer valuse...<br>");
		}
		RequestDispatcher rd = request.getRequestDispatcher("choice.html");
		rd.include(request, response);
	}

}
