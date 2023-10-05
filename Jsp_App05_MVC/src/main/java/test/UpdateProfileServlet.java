package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateProfileServlet
 */
@WebServlet("/update")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession hs = request.getSession(false);
		if (hs == null) {

			request.setAttribute("msg", "Session expried...<br><br>");
			request.getRequestDispatcher("invalid.jsp").include(request, response);
		} else {
			UserBean ub = (UserBean) hs.getAttribute("ubean");
			ub.setAddr(request.getParameter("addr"));
			ub.setmId(request.getParameter("mid"));
			ub.setPhNo(Long.parseLong(request.getParameter("phno")));

			int k = new UpdateDao().update(ub);
			if (k > 0) {
				request.getRequestDispatcher("update.jsp").forward(request, response);
			}

		}

	}

}
