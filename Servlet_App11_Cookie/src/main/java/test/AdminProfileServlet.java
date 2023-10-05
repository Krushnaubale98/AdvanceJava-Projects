package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/dis2")
public class AdminProfileServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		Cookie ck[] = request.getCookies();

		if (ck == null) {

			pw.println("Session expired....<br><br>");
			request.getRequestDispatcher("login2.html").include(request, response);
		} else {

			String uname = ck[0].getValue();
			String pword = ck[1].getValue();

			UserBean ub = new AdminProfileDao().profile(uname, pword);
			if (ub == null) {
				pw.println("UserBean  is null...<br>");
			} else {
				pw.println(ub.getfName() + " Admin Profile<br><br>");
				pw.println(ub.getuName() + "&nbsp&nbsp&nbsp" + ub.getpWord() + "&nbsp&nbsp&nbsp" + ub.getfName()
						+ "&nbsp&nbsp&nbsp" + ub.getlName() + "&nbsp&nbsp&nbsp" + ub.getAddr() + "&nbsp&nbsp&nbsp"
						+ ub.getmId() + "&nbsp&nbsp&nbsp" + ub.getPhNo());

			}
		}
	}
}