package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		HttpSession hs = request.getSession(); //accessing existing session
		if (hs == null) {
			pw.println("Session expired");
			request.getRequestDispatcher("login.html").include(request, response);
		} else {
			hs.invalidate(); //session destroyed
			pw.println("User loggedout successfully...<br><br>");
		}
		request.getRequestDispatcher("login.html").include(request, response);

	}

}
