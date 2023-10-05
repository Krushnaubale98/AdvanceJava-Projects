package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FirstServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		ProductBean pb = new RetrieveDao().retrieve(request);

		if (pb == null) {

			pw.println("invalid productCode");
			request.getRequestDispatcher("input.html").include(request, response);
		} else {
			pw.println("<a href='second?pcode=" + pb.getPcode() + "&pname=" + pb.getPname() + "&pprice=" + pb.getPprice()
					+ "&pqty=" + pb.getQty() + "'>ViewProductDetails</a>");
		}
	}

}
