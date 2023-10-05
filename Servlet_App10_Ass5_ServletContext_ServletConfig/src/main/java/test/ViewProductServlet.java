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

/**
 * Servlet implementation class ViewProductServlet
 */
@SuppressWarnings("serial")
public class ViewProductServlet extends GenericServlet {

	public ViewDao rd = null; //instance variable

	public void init() throws ServletException {

		rd = new ViewDao();
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		ArrayList<ProductBean> al = rd.retrieve();

		if (al.size() == 0) {
			pw.println("Products not Available....<br>");
			request.getRequestDispatcher("details").include(request, response);

		} else {

			Iterator<ProductBean> it = al.iterator();
			while (it.hasNext()) {
				ProductBean pb = (ProductBean) it.next();

				pw.println("<html><body><h3>");

				pw.println("<a href='http://localhost:8082/Servlet_App10_Ass5/details?pcode="+pb.getCode()+"' name=pcode >");
				
				pw.println(pb.getCode() + "<br>");
				pw.println("</a>");
				
				pw.println("</h3></body></html>");

			} //end of loop
			request.getRequestDispatcher("details").include(request, response);
			pw.println("<br>");


		} //end of if-else

	}

}
