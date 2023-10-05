package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/add")
public class AddServlet extends GenericServlet {

	public AddDao ad = null;//instance variable
	public BookBean bb = null;//instance variable

	public void init() {
		//initialization

		ad = new AddDao();
		bb = new BookBean();

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		bb.setBcode(req.getParameter("bcode"));
		bb.setBname(req.getParameter("bname"));
		bb.setBauthor(req.getParameter("bauthor"));
		bb.setBprice(Float.parseFloat(req.getParameter("bprice")));
		bb.setBqty(Integer.parseInt(req.getParameter("bqty")));

		int k = ad.add(bb);

		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");

		if (k > 0) {

			pw.println("Book add successfully...<br><br>");
			req.getRequestDispatcher("add.html").include(req, res);
		} else {

			pw.println("Book not added into a DB...<Br><Br>");
			req.getRequestDispatcher("add.html").include(req, res);
		}
	}

}
