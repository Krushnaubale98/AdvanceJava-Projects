package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/edit")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession(false);
		if (hs == null) {
			request.setAttribute("msg", "Session exprired....<br>");
			request.getRequestDispatcher("invalid.jsp").include(request, response);
		} else {
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		}

	}

}
