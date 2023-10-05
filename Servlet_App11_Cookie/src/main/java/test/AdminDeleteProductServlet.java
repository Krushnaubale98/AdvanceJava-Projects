package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class AdminDeleteProductServlet extends HttpServlet{

	public ProductBean pb = null; //instance variable
	public AdminDeleteProductDao dd = null; //instacne variable

	public void init() {

		pb = new ProductBean();
		dd = new AdminDeleteProductDao();

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException {

		try {
			PrintWriter pw = res.getWriter();
			res.setContentType("text/html");

			pb.setCode(req.getParameter("pcode"));

			int k = dd.delete(pb);

			if (k > 0) {
				pw.println("Prodct deleted successfully....<br><br>");
				req.getRequestDispatcher("delete.html").include(req, res);
			} else {
				pw.println("Prodct Code is wrong...<br><br>");
				req.getRequestDispatcher("delete.html").include(req, res);
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
