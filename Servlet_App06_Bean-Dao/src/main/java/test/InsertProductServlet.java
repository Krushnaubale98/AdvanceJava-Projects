package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class AddProductServlet
 */
@SuppressWarnings("serial")
@WebServlet("/add")
public class InsertProductServlet extends GenericServlet {
	public ProductBean pb = null; //instance variable
	public InsertDao id = null;//instance variable

	public void init() throws ServletException {

		pb = new ProductBean();
		id = new InsertDao();
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		pb.setCode(request.getParameter("pcode"));
		pb.setName(request.getParameter("pname"));
		pb.setPrice(Float.parseFloat(request.getParameter("pprice")));
		pb.setQty(Integer.parseInt(request.getParameter("pqty")));

		int k = id.insert(pb); //bean object as parameter

		PrintWriter pw = response.getWriter();

		response.setContentType("text/html");

		if (k > 0) {
			pw.println("product added successfully...<br>");

			RequestDispatcher rd = request.getRequestDispatcher("input.html");

			rd.include(request, response);
		}

	}

}
