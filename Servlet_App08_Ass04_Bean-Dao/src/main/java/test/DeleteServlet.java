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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see GenericServlet#GenericServlet()
	 */
	public DeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		String pcode=(request.getParameter("bcode"));
		int code = new DeleteDao().delete(pcode);

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		if (code > 0) {
			request.getRequestDispatcher("delete.html").include(request, response);
			pw.println(code + " Deleted successfully ...<Br><br>");

		} else {
			request.getRequestDispatcher("delete.html").include(request, response);
			pw.println("Pcode is wrong....<Br><br>");

		}

	}

}
