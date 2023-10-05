package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class Employee_Servlet
 */
@WebServlet("/show")
public class Employee_Servlet implements Servlet {

	/**
	 * Default constructor.
	 */
	public Employee_Servlet() {
		// NoCode
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
		// NoCode
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
		return "Employee_Servlet";
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		String eId = request.getParameter("eid");
		String eName = request.getParameter("ename");
		String eDesg = request.getParameter("eauthor");
		float eBal = Float.parseFloat(request.getParameter("ebal"));

		pw.println("======Details of Employees======");
		pw.println("<br> Eid: " + eId);
		pw.println("<br> Ename:" + eName);
		pw.println("<br> Edesg: " + eDesg);
		pw.println("<br> Ebal: " + eBal);
	}

}
