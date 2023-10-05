package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterSevlet
 */
@SuppressWarnings("serial")
@WebServlet("/reg")
public class UserRegisterSevlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		UserBean ub = new UserBean(); //UserBean object

		ub.setuName(request.getParameter("uname"));
		ub.setpWord(request.getParameter("pword"));
		ub.setfName(request.getParameter("fname"));
		ub.setLName(request.getParameter("lname"));
		ub.setAddr(request.getParameter("addr"));
		ub.setmId(request.getParameter("mid"));
		ub.setPhNo(Long.parseLong(request.getParameter("phno")));

		int k = new UserRegisterDao().register(ub);

		if (k > 0) {

			pw.println("User registerd sccuessfully...<br>");
			request.getRequestDispatcher("login1.html").include(request, response);

		} else {
			pw.println("User not registerd sccuessfully...<br>");
			request.getRequestDispatcher("login1.html").include(request, response);

		}
	}

}
