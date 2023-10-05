
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
 * Servlet implementation class LoginServlet
 */
@SuppressWarnings("serial")
@WebServlet("/log")
public class UserLoginServlet extends HttpServlet {

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		UserBean ub = new UserLoginDao().login(request);

		if (ub == null) {
			pw.println("Invalid login process...<br>");
			request.getRequestDispatcher("login1.html").include(request, response);

		} else {

			Cookie ck2 = new Cookie("uName", ub.getuName());
			Cookie ck3 = new Cookie("pWord", ub.getpWord());
			response.addCookie(ck2);
			response.addCookie(ck3);

			Cookie ck1 = new Cookie("fName", ub.getfName());
			response.addCookie(ck1);//adding Cookie to respones
			pw.println("Welcome User : " + ub.getfName() + "<br><br><br>");

			request.getRequestDispatcher("link1.html").include(request, response);

		}
	}
}
