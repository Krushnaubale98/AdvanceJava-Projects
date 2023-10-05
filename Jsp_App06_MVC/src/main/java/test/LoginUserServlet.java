package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/log1")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserBean ub = new LoginDao().login(request);
		if (ub == null) {
			request.setAttribute("msg", "Invalid login process");
			request.getRequestDispatcher("Invalid.jsp").forward(request, response);

		} else {
			HttpSession hs = request.getSession(); //creating session
			hs.setAttribute("ubean", ub); //attribute added into a session
			request.getRequestDispatcher("Valid.jsp").forward(request, response);
		}
	}

}
