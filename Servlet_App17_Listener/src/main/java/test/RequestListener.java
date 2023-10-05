package test;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class RequestListener
 *
 */
@WebListener
public class RequestListener implements ServletRequestListener {

	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("Request object initialized...");
	}
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("Request Object Destoryed...");
	}
}
