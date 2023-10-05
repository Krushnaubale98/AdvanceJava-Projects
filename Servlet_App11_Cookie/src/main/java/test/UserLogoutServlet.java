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
 * Servlet implementation class UserLogoutServlet
 */
@WebServlet("/logout")
public class UserLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		Cookie c[] = request.getCookies();

		if (c == null) {
			pw.println("Session Expired...<br>");

		} else {
			c[0].setMaxAge(0); //session expired
			pw.println("User Logged out Successfuly...<br><br>");
		}
		request.getRequestDispatcher("login1.html").include(request, response);
	}

}
