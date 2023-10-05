package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewProfileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		HttpSession hs = request.getSession(); //accessing existing session
		if (hs == null) {
			pw.println("Session expried...<br>");
			request.getRequestDispatcher("login.html").include(request, response);

		} else {
			UserBean ub = (UserBean) hs.getAttribute("ubean"); //getting the attribute to session
			pw.println("Page of " + ub.getfName() + "<br><br>");
			request.getRequestDispatcher("link.html").include(request, response);

			pw.println("<br><br><br>" +ub.getuName()+"&nbsp&nbsp&nbsp" + ub.getfName() + "&nbsp&nbsp&nbsp" + ub.getlName() + "&nbsp&nbsp&nbsp" + ub.getAddr()
					+ "&nbsp&nbsp&nbsp"+ub.getmId()+"&nbsp&nbsp&nbsp" + ub.getPhNo());

		}

	}

}
