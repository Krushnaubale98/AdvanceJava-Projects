package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/add")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession hs = request.getSession(false);
		if (hs == null) {
			request.setAttribute("msg", "Session expired...<br><br>");
			request.getRequestDispatcher("Invalid.jsp").forward(request, response);
		} else {
			ProductBean pb = new ProductBean(); //bean object
			pb.setCode(request.getParameter("pcode"));
			pb.setName(request.getParameter("pname"));
			pb.setPrice(Float.parseFloat(request.getParameter("pprice")));
			pb.setQty(Integer.parseInt(request.getParameter("pqty")));

			int k = new AddProductDao().insert(pb);
			if(k>0) {
				request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
			}
			
		}
	}

}
