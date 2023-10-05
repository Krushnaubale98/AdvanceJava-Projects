package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserProfileServlet
 */
@SuppressWarnings("serial")
@WebServlet("/dis")
public class UserProfileServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		Cookie c[] = request.getCookies();

		if (c == null) {
			pw.println("session expired.....<br><br>");
			request.getRequestDispatcher("login1.html").include(request, response);
		} else {

			String uname = c[0].getValue();
			String pword = c[1].getValue();

			ArrayList<UserBean> al = new UserProfileDao().retrieve();

			if (al.size() == 0) {

				pw.println("<br><br>User not Available...<br>");

			} else {
				Iterator<UserBean> it = al.iterator();
				request.getRequestDispatcher("user.html").include(request, response);
				pw.println("======user Details=======<br>");
				while (it.hasNext()) {
					UserBean ub = it.next();
					if (ub.getuName().equals(uname) && ub.getpWord().equals(pword)) {
						pw.println(ub.getuName() + " &nbsp&nbsp&nbsp" + ub.getpWord() + "&nbsp&nbsp&nbsp"
								+ ub.getfName() + "&nbsp&nbsp&nbsp" + ub.getlName() + "&nbsp&nbsp&nbsp" + ub.getAddr()
								+ "&nbsp&nbsp&nbsp" + ub.getmId() + "&nbsp&nbsp&nbsp" + ub.getPhNo() + "<br>");
					}
				} //end of while loop
			}
		}
	}
}