package test;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String s1 = request.getParameter("s1");
		ServletContext sct = this.getServletContext();
		sct.setAttribute("logintype", s1); //added to context object
		if (s1.equals("UserLogin")) {
			request.getRequestDispatcher("Login1.html").include(request, response);
		} else {
			request.getRequestDispatcher("Login2.html").include(request, response);
		}
	}

}
