package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class UpdateSevlet
 */
@WebServlet("/update")
public class UpdateSevlet extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see GenericServlet#GenericServlet()
	 */
	public UpdateSevlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateDao ud = null; //instance variable
	public BookBean bb = null;//instance variable

	public void init() {
		ud = new UpdateDao();
		bb = new BookBean();
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		bb.setBname(request.getParameter("bname"));
		bb.setBauthor(request.getParameter("bauthor"));
		bb.setBprice(Float.parseFloat(request.getParameter("bprice")));
		bb.setBqty(Integer.parseInt(request.getParameter("bqty")));
		bb.setBcode(request.getParameter("bcode"));

		int k = ud.update(bb);
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		if (k > 0) {
			pw.println(bb.getBcode() + " Updated successfully...<br><b>");
			request.getRequestDispatcher("update.html").include(request, response);
		} else {
			pw.println("invalid product code...");
			request.getRequestDispatcher("update.html").include(request, response);
		}

	}

}
