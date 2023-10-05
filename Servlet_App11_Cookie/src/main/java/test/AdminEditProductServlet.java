package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class AdminEditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductBean pb = null; //instance variable
	public AdminEditProductDao pd = null; //instance variable

	public void init() {

		pb = new ProductBean();
		pd = new AdminEditProductDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		pb.setName(request.getParameter("pname"));
		pb.setPrice(Float.parseFloat(request.getParameter("pprice")));
		pb.setQty(Integer.parseInt(request.getParameter("pqty")));
		pb.setCode(request.getParameter("pcode"));

		int k = pd.edit(pb);

		if (k > 0) {
			pw.print(pb.getCode() + " Product Updated successfully...<br><br>");
			request.getRequestDispatcher("edit.html").include(request, response);

		} else {
			pw.println("Product Code is wrong...<br><br>");
			request.getRequestDispatcher("edit.html").include(request, response);
		}
	}

}
