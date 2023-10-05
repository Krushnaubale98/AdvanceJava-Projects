package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession hs = request.getSession(false);
		if (hs == null) {
			request.setAttribute("msg", "session expried...<br>");
			request.getRequestDispatcher("Invalid.jsp").forward(request, response);
		} else {
			int k = new DeleteProductDao().delete(request);

			if (k > 0) {
				request.getRequestDispatcher("Delete.jsp").forward(request, response);
			} else {

				request.getRequestDispatcher("EditFail.jsp").forward(request, response);

			}
		}
	}

}
