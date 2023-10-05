package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/log")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
		UserBean ub=new LoginDao().login(request);
		
		if(ub==null) {
			pw.println("Invalid Login process..<br>");
			request.getRequestDispatcher("login.html").include(request, response);
			
		}else {
			
			HttpSession hs=request.getSession();// creating new session
			hs.setAttribute("ubean", ub); //adding attribute to session
			pw.println("Welcome user: "+ub.getfName()+"<br><br><br>");
			request.getRequestDispatcher("link.html").include(request, response);
			
			
		}
		
	
	}

}
