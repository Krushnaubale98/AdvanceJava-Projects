package test;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
@WebListener
public class ContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {

		System.out.println("Context object initialized...");
		ServletContext sct = sce.getServletContext();
		System.out.println("ServletInfo: " + sct.getServerInfo());

	}

	public void contextDestroyed(ServletContextEvent sec) {
		System.out.println("Context object destroyed...");
	}
}
