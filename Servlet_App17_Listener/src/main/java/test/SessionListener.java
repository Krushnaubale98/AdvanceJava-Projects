package test;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener,HttpSessionAttributeListener {

	public void sessionCreated(HttpSessionEvent hse) {
		System.out.println("Session created...");
	}

	public void sessionDestroyed(HttpSessionEvent hse) {
		System.out.println("Session destroyed...");
	}

	public void attributeAdded(HttpSessionBindingEvent hsbe) {
		System.out.println("Attribute added to session...");
	}

	public void attributeRemoved(HttpSessionBindingEvent hsbe) {

		System.out.println("Attribute removed from session...");
	}
}