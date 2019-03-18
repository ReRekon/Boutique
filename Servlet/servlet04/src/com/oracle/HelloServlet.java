package com.oracle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet extends GenericServlet {

	public HelloServlet()
	{
		System.out.println("HelloServlet构造方法。。。。。。。");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("HelloServlet init,,,,,,,,");
	}

	@Override
	public void destroy() {
		System.out.println("HelloServlet---destory........");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) 
			throws ServletException, IOException 
	{
		System.out.println("HelloServlet---service.....");
		arg1.setContentType("text/html;charset=gbk");
		PrintWriter pw=arg1.getWriter();
		pw.println("<h1>Hello Servlet by xml</h1>");
		pw.close();

	}

}
