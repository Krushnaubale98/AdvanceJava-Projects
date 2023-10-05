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
 * Servlet implementation class AdminViewProductServlet
 */
@WebServlet("/view2")
public class AdminViewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminViewProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		Cookie ck[] = request.getCookies();

		if (ck == null) {
			pw.println("Session expired.....<br><br>");
			request.getRequestDispatcher("login2.html").include(request, response);
		} else {

			ArrayList<ProductBean> al = new AdminViewProductDao().view();

			if (al.size() == 0) {

				pw.println("Product not Available....<Br><Br>");

			} else {

				Iterator it = al.iterator();

				pw.print("<br>Avaliable all products.<br><br>");
				while (it.hasNext()) {

					ProductBean pb = (ProductBean) it.next();

					pw.println(pb.getCode() + "&nbsp&nbsp" + pb.getName() + "&nbsp&nbsp" + pb.getPrice() + "&nbsp&nbsp"
							+ pb.getQty() +"<br>");
				}
			}
		}
	}

}
