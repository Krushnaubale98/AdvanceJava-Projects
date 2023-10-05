package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/reg")
public class RegisterServlet extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */

	public RegisterDao rd = null;
	public UserBean ub = null;

	public void init(ServletConfig config) throws ServletException {

		rd = new RegisterDao();
		ub = new UserBean();
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html");

			ub.setUname(request.getParameter("uname"));
			ub.setPword(request.getParameter("pword"));
			ub.setFname(request.getParameter("fname"));
			ub.setLname(request.getParameter("lname"));
			ub.setAddr(request.getParameter("addr"));
			ub.setMid(request.getParameter("mid"));
			ub.setPhno(Long.parseLong(request.getParameter("phno")));

			int k = rd.register(ub);

			if (k > 0) {
				pw.println("User regiser successfuly...<br>");
				request.getRequestDispatcher("register.html").include(request, response);
			} else {
				pw.println("User not register...");
				request.getRequestDispatcher("register.html").include(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
