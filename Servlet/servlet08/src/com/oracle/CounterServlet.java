package com.oracle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/counter")
public class CounterServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		
		resp.setContentType("text/html;charset=gbk");
		PrintWriter out=resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>页面计数器</title>");
		out.println("</head>");
		out.println("<body>");
		
		/*
		 * ServletConfig sc=this.getServletConfig(); ServletContext
		 * scf=this.getServletContext();
		 */
		ServletContext sc=this.getServletContext();
		
		Integer counter=(Integer)sc.getAttribute("counter");
		if(null==counter)
		{
			counter=1;
		}
		
		out.println("<h1>当前页面被访问了"+counter+"次!</h1>");
		
		
		counter++;
		sc.setAttribute("counter", counter);
		out.println("</body>");
		out.println("</html>");
	}

	
	
}









