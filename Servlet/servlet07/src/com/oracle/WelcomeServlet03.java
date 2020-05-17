package com.oracle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/welcome03")
public class WelcomeServlet03 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=gbk");
		PrintWriter out=resp.getWriter();
		
		out.println("<h1>do get.........</h1>");
		out.println("<ul>");
		java.util.Enumeration<java.lang.String> all=req.getHeaderNames();
		while(all.hasMoreElements())
		{
			String hname=all.nextElement();
			String value=req.getHeader(hname);
			out.println("<li>"+hname+":&nbsp"+value+"</li>");
		}
		
		out.println("</ul>");
		
		out.println("<hr/>");
		out.println("<h1>query string:"+req.getQueryString()+"</h1>");
		out.println("<h1>getRequestURI:"+req.getRequestURI()+"</h1>");
		out.println("<h1>getRequestURL:"+req.getRequestURL()+"</h1>");
		out.close();		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * resp.setContentType("text/html;charset=gbk"); PrintWriter
		 * out=resp.getWriter();
		 * 
		 * 
		 * 
		 * out.println("<h1>do post.........</h1>"); out.close();
		 */
		doGet(req,resp);
	}	
}
