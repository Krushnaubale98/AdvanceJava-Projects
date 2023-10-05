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
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	public UserBean ub = null; //instance varable
	public UpdateDao ud = null; //instance variable

	public void init() {

		ub = new UserBean();
		ud = new UpdateDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		HttpSession hs = request.getSession(); //getting existing session
		if (hs == null) {
			pw.println("<br>Session expired...<br>");
			request.getRequestDispatcher("login.html").include(request, response);

		} else {

			ub.setAddr(request.getParameter("addr"));
			ub.setmId(request.getParameter("mid"));
			ub.setPhNo(Long.parseLong(request.getParameter("phno")));
			ub.setuName(request.getParameter("uname"));

			int k = ud.update(ub);
			hs.removeAttribute("ubean");
			hs.setAttribute("ubean", ub);

			if (k > 0) {
				
				pw.println(ub.getuName() + " Updated Successfully...<br><br>");
				request.getRequestDispatcher("update.html").include(request, response);
			} else {
				pw.println("UserName is wrong...<br><br>");
				request.getRequestDispatcher("update.html").include(request, response);

			}
		}

	}

}
