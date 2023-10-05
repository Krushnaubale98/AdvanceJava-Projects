package test;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/second")
public class SecondServlet extends HttpServlet{
   protected void doGet(HttpServletRequest req,
     HttpServletResponse res)throws ServletException,IOException{
	   PrintWriter pw = res.getWriter();
	   res.setContentType("text/html");
	   pw.println("====SecondServlet====");
	   pw.println("<br>UserName:"+req.getParameter("uname"));
	   pw.println("<br>MailId:"+req.getParameter("mid"));
   }
}
