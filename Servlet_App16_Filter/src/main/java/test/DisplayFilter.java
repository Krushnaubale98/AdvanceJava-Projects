package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class DisplayFilter implements Filter {
	public FilterConfig fc; //Instance variable

	public void init(FilterConfig fc) {
		this.fc = fc;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		pw.println("<br> FilterName: " + fc.getFilterName());
		pw.println("<br> FilterConfigValue: " + fc.getInitParameter("a"));
	}

}
