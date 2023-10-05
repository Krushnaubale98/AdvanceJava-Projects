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
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/dis")
public class DisplayServlet implements Servlet {

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		//NoCode
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		//NoCode
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
		// TODO Auto-generated method stub
		return "DisplayServlet";
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String pC = request.getParameter("pcode");
		String pN = request.getParameter("pname");
		float pP = Float.parseFloat(request.getParameter("pprice"));
		int pQ = Integer.parseInt(request.getParameter("pqty"));

		System.out.println("======ProductDetails========");
		pw.println("<br> PCOde: " + pC);
		pw.println("<br> PName: " + pN);
		pw.println("<br>PPrice: " + pP);
		pw.println("<br> PQty: " + pQ);

	}

}
