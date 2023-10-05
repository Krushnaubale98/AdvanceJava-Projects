package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/log2")
public class LoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserBean ub = new LoginDao().login(request); //Bean object

		if (ub == null) {
			request.setAttribute("msg", "Invalid Loging process...<br>");
			request.getRequestDispatcher("Invalid.jsp").forward(request, response);

		} else {

			HttpSession hs = request.getSession(); //creatin session
			hs.setAttribute("ubean", ub); //added attribute into a session
			request.getRequestDispatcher("Valid.jsp").forward(request, response);
		}
	}

}
