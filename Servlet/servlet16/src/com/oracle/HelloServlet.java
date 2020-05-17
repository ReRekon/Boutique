package com.oracle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException 
	{
		
		System.out.println("HelloServlet.....service..........");
		arg1.setContentType("text/html;charset=gbk");
		PrintWriter pw=arg1.getWriter();
		pw.println("<h1>Hello Servlet</h1>");
		pw.close();

	}

}
