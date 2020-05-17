package com.oracle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class WebinitListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
		System.out.println("������ServletContext����"+arg0.getServletContext());

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		ServletContext sc=arg0.getServletContext();
		System.out.println("ʵ������ServletContext����"+sc);
		
		sc.setInitParameter("encode", "utf-8");

	}

}
