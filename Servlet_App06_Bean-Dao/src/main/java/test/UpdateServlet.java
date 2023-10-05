package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class UpdateServlet
 */
@SuppressWarnings({ "serial", "unused" })
@WebServlet("/update")
public class UpdateServlet extends GenericServlet implements Servlet {

	public UpdateDao ud = null;
	public ProductBean pb = null;

	public void init() {
		ud = new UpdateDao();
		pb = new ProductBean();

	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		pb.setCode(request.getParameter("pcode"));
		pb.setName(request.getParameter("pname"));
		pb.setPrice(Float.parseFloat(request.getParameter("pprice")));
		pb.setQty(Integer.parseInt(request.getParameter("pqty")));

		int k = ud.update(pb);

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		if (k > 0) {
			pw.println(pb.getCode() + ": Updated successfully...");
			
			/*
			 * RequestDispatcher rd = request.getRequestDispatcher("update.html");
			 * rd.include(request, response);
			 */} else {
			pw.println("Wrong pcode...");
		}
		
		
		request.getRequestDispatcher("update.html").include(request, response);

	}

}
