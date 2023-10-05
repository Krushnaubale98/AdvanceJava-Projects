package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession hs = request.getSession();

		if (hs == null) {
			request.setAttribute("msg", "Session expried...<br><br>");
			request.getRequestDispatcher("Invalid.jsp").forward(request, response);
		} else {
			ProductBean pb = (ProductBean) hs.getAttribute("pb");
			pb.setPrice(Float.parseFloat(request.getParameter("pprice")));
			pb.setQty(Integer.parseInt(request.getParameter("pqty")));
			int k = new UpdateProductDao().update(pb);
			if (k > 0) {
				request.getRequestDispatcher("Update.jsp").forward(request, response);
			}
		}

	}

}
