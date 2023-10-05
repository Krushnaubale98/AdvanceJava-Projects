package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/log")
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		String fName = new LoginDao().login(request);

		if (fName == null) {
			pw.println("Invalid login process...<br><br>");
			request.getRequestDispatcher("login.html").include(request, response);

		} else {
			request.setAttribute("fname", fName); //Adding attribute to request
			chain.doFilter(request, response); //Linking servlet_Program	
		}
	}

}
