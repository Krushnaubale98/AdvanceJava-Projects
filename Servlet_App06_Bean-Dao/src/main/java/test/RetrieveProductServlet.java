package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class ViewProductServlet
 */
@SuppressWarnings("serial")
@WebServlet("/view")
public class RetrieveProductServlet extends GenericServlet {

	public RetrieveDao rd = null; //instance variable

	public void init() throws ServletException {

		rd = new RetrieveDao();
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		ArrayList<ProductBean> al = rd.retrieve();

		if (al.size() == 0) {
			pw.println("Products not Available....<br>");
			request.getRequestDispatcher("input.html").include(request, response);

		} else {

			Iterator<ProductBean> it = al.iterator();
			while (it.hasNext()) {
				ProductBean pb = (ProductBean) it.next();

				pw.println(pb.getCode() + "&nbsp &nbsp" + pb.getName() + "&nbsp&nbsp" + pb.getPrice() + "&nbsp&nbsp"
						+ pb.getQty() + "<br>");

			} //end of loop
			RequestDispatcher rd = request.getRequestDispatcher("input.html");
			rd.include(request, response);

		} //end of if-else

	}

}
