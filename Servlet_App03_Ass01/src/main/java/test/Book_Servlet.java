package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

/*
 * Servlet implementation class Book_Servlet
 */
@WebServlet("/show")
public class Book_Servlet implements Servlet {

	/**
	 * Default constructor.
	 */
	public Book_Servlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// NoCode
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// NoCode		`					
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		return this.getServletConfig();

	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {

		return "Book_Servlet";
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		String bC = request.getParameter("bcode");
		String bN = request.getParameter("bname");
		String bA = request.getParameter("bauthor");
		float bP = Float.parseFloat(request.getParameter("bprice"));
		int bQ = Integer.parseInt(request.getParameter("bqty"));

		pw.println("=======Display bookDetails====");
		pw.println("<html><body bgcolor= yellow text=red>");
		pw.println(" <br> BookCode: " + bC);
		pw.println("<br> BookName: " + bN);
		pw.println("<br> BookAuthor: " + bA);
		pw.println("<br> BookPrice: " + bP);
		pw.println("<br> BookQty: " + bQ);
		pw.println("</body></html>");
	}

}
