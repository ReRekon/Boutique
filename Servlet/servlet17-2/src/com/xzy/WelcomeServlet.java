package com.xzy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Service;
@WebServlet("/admin/wel")
public class WelcomeServlet extends HttpServlet
{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		 System.out.println(".....................service(req,resp)..................");
		 resp.setContentType("text/html;charset=utf-8");
		 req.setCharacterEncoding("utf-8");
		 PrintWriter out=resp.getWriter();
		 
		 String name=null!=req.getParameter("name")?req.getParameter("name"):"";
		 
		 out.println("<h1>Welcome,"+name+"!</h1>");
		 
		 
		 out.close();
	}

}
