package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/edit")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession hs = request.getSession(false);

		if (hs == null) {
			request.setAttribute("msg", "Session expired...<br><br>");
			request.getRequestDispatcher("Invalid.Jsp").forward(request, response);
		} else {
			ProductBean pb = new EditProductDao().retrieve(request);
			if (pb == null) {
				request.getRequestDispatcher("EditFail.jsp").forward(request, response);
			} else {
				hs.setAttribute("pb", pb);
				request.getRequestDispatcher("Edit.jsp").forward(request, response);

			}
		}
	}

}
