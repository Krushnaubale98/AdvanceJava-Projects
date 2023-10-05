package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet(name = "log", urlPatterns = { "/log" })
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserBean ub = new LoginDao().login(request);

		if (ub == null) {
			request.setAttribute("msg", "invalid login process...<br>");
			request.getRequestDispatcher("invalid.jsp").forward(request, response);
		} else {

			HttpSession hs = request.getSession();
			hs.setAttribute("ubean", ub);
			request.getRequestDispatcher("valid.jsp").include(request, response);
		}
	}

}
