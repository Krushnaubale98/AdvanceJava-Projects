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
 * Servlet implementation class ProductViewServlet
 */
@WebServlet("/view")
public class UserProductRetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		Cookie c[] = request.getCookies(); //Getting Cookies from the servlet

		if (c == null) {
			pw.println("Session expried ...<br>");
			request.getRequestDispatcher("login1.html").include(request, response);
		} else {
			String fName = c[2].getValue();
			pw.println("page of user :" + fName + "<br>");

			ArrayList<ProductBean> al = new UserProductRetrieveDao().retrieve();

			if (al.size() == 0) {

				pw.println("<br><br>Products not Available...<br>");

			} else {
				Iterator<ProductBean> it = al.iterator();

				request.getRequestDispatcher("user.html").include(request, response);
                
				pw.println("======product details=====<br>");
				while (it.hasNext()) {
					ProductBean pb = it.next();

					pw.println(pb.getCode() + " &nbsp&nbsp&nbsp" + pb.getName() + "&nbsp&nbsp&nbsp" + pb.getPrice()
							+ "&nbsp&nbsp&nbsp" + pb.getQty() + "<br>");

				} //end of while loop

			} //end of the inner if-else

		} //end of the outer if-else

	}

}
