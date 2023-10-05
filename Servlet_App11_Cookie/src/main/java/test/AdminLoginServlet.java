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
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/log2")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		UserBean ub = new AdminLoginDao().login(request);

		if (ub == null) {
			pw.println("Invalid login process...<br>");
			request.getRequestDispatcher("login2.html").include(request, response);
		} else {

			Cookie ck1 = new Cookie("uName", ub.getuName());
			Cookie ck2 = new Cookie("pWord", ub.getpWord());
			response.addCookie(ck1);//adding Cookie to respones
			response.addCookie(ck2);//adding Cookie to respones
			pw.println("Welcome Admin :" + ub.getfName() + "<br><br>");

			request.getRequestDispatcher("link2.html").include(request, response);
		}

	}

}
