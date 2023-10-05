package test;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewProductServlet
 */
@WebServlet("/view")
public class ViewProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession hs = request.getSession();
		if (hs == null) {
			request.setAttribute("msg", "Session expired...<br><br>");
			request.getRequestDispatcher("Invalid.jsp").forward(request, response);
		} else {

			ArrayList<ProductBean> al = new ViewProductsDao().view();
			hs.setAttribute("al", al);
			request.getRequestDispatcher("ViewProducts.jsp").forward(request, response);
		}

	}

}
