package test;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class ChoiceServlet
 */
@WebServlet("/choice")
public class ChoiceServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		String s1 = request.getParameter("s1"); //getting data from the request object
		if (s1.equals("Add")) {
			RequestDispatcher rd = request.getRequestDispatcher("add");
			rd.forward(request, response);

		} else if (s1.equals("Sub")) {
			RequestDispatcher rd = request.getRequestDispatcher("sub");
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("mult");
			rd.forward(request, response);
		}
	}

}
