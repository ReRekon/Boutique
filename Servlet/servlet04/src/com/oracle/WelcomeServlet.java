package com.oracle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet(value="/welcome",loadOnStartup=3)
public class WelcomeServlet extends GenericServlet {
	public WelcomeServlet()
	{
		System.out.println("WelcomeServlet的构造方法");
	}
	@Override
	public void destroy() {
		System.out.println("WelcomeServlet destory.......");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("WelcomeServlet init.......");
	}
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) 
			throws ServletException, IOException 
	{
		System.out.println("WelcomeServlet service.......");
		
		arg1.setContentType("text/html;charset=gbk");
		PrintWriter pw=arg1.getWriter();
		pw.println("<h1>Welcome Servlet by annotation</h1>");
		pw.close();

	}

}
