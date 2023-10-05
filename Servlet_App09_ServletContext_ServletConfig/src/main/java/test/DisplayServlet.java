package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

/**
 * Servlet implementation class DisplayServlet
 */
public class DisplayServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public DisplayServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		pw.println("Welcome user: " + request.getParameter("name") + "<br>");

		pw.println("===========SevletContext============<br>");
		ServletContext sct = this.getServletContext();
		//Accessing ServletContext object refrence
		pw.println("ServerInfo:" + sct.getServerInfo() + "<br>");
		pw.println("ContextValue: " + sct.getInitParameter("a") + "<br>");

		pw.println("========ServletConfig============<br>");
		ServletConfig sc = this.getServletConfig();
		//Accessing ServletConfig object refrence
		pw.println("servletName: " + sc.getServletName() + "<br>");
		pw.println("ConfigValue: " + sc.getInitParameter("b") + "<br>");

	}

}
