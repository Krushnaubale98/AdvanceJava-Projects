package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLogoutServlet
 */
@WebServlet("/logout2")
public class AdminLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		Cookie ck[] = request.getCookies();

		if (ck == null) {
			pw.println("Session expired...<br><br>");
			request.getRequestDispatcher("login2.html").include(request, response);
		} else {

			ck[0].setMaxAge(0); //session logout(closed)
			pw.println("Admin logout...<br><br>");

			request.getRequestDispatcher("login2.html").include(request, response);
		}
	}

}
