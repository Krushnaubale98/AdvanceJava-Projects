package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/view")
public class ViewServlet extends GenericServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	public ViewDao vd = null; //instance variable
	public BookBean bb = null; //instance variable

	public void init() {

		vd = new ViewDao();
		bb = new BookBean();
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		List<BookBean> al = vd.view();

		if (al.size() == 0) {
			request.getRequestDispatcher("view.html").include(request, response);
			pw.println("Books are not available...<Br>Br>");
		} else {
			request.getRequestDispatcher("view.html").include(request, response);
			Iterator<BookBean> it = al.iterator();

			while (it.hasNext()) {
				pw.println(it.next() + "<Br>");
			}
		}

	}

}
