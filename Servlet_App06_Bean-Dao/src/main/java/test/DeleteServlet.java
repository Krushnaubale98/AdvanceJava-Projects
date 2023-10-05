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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	public ProductBean pb = null; //Instatnce variable

	public void init() {
		pb = new ProductBean();

	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		//get parameter
		try {
			int k = DeleteDao.deleteprod(request.getParameter("pcode"));

			if (k > 0) {
				pw.println( " product deleted.. ");
				RequestDispatcher rd = request.getRequestDispatcher("delete.html");
				rd.include(request, response);

			} else {
				pw.println("Pcode wrong...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("delete.html");
		rd.include(request, response);

	}

}
