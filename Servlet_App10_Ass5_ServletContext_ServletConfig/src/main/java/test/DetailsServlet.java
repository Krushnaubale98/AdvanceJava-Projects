package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class DetailsServlet extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	public ViewDao rd = null; //instance variable

	public void init() throws ServletException {

		rd = new ViewDao();
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		String s1 = request.getParameter("pcode");
		ArrayList<ProductBean> al = rd.retrieve();

		if (al.size() == 0) {
			pw.println("Products not Available....<br>");
			request.getRequestDispatcher("details").include(request, response);

		} else {

			Iterator<ProductBean> it = al.iterator();
			while (it.hasNext()) {
				ProductBean pb = (ProductBean) it.next();

				if (s1.equals(pb.getCode())) {

					pw.println(pb.getCode() + "\t" + pb.getName() + "\t" + pb.getPrice() + "\t" + pb.getQty());
				}

			} //end of loop

		} //end of if-else

	}

}
