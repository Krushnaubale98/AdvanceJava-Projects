package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewProfileServlet
 */
@WebServlet("/profile")
public class ViewProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	HttpSession hs=request.getSession(false);  //accessing existing session
	if(hs==null) {
		request.setAttribute("ubean", "Session experied....<br><Br>");
		request.getRequestDispatcher("Invalid.jsp").forward(request, response);

	}else {
		
		request.getRequestDispatcher("View.jsp").forward(request, response);
		
	}
	
	}

}
