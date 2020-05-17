package com.oracle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextServlet
 */
//@WebServlet("/context")
public class ContextServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=gbk");
		PrintWriter out=response.getWriter();
		ServletContext sc=this.getServletContext();
		out.println("<h1>"+sc.getContextPath()+"</h1>");
		
		//sc.setInitParameter("hello", "welcome.....");
		
		out.println("<h1>"+sc.getInitParameter("encode")+"</h1>");
		//out.println("<h1>"+sc.getInitParameter("hello")+"</h1>"); 
		out.println("<h1>"+sc.getMimeType("./img/a8.jpg")+"</h1>");
		out.println("<h1>"+sc.getMimeType("./img/img.zip")+"</h1>");
		out.println("<h1>"+sc.getRealPath("./img/a8.jpg")+"</h1>");
		out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
