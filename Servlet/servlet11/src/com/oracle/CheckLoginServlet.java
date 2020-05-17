package com.oracle;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/checklogin")
public class CheckLoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		req.setCharacterEncoding("utf-8");
		
		
		String uname=null!=req.getParameter("uname")?req.getParameter("uname"):"";
		String upwd=null!=req.getParameter("upwd")?req.getParameter("upwd"):"";
		
		System.out.println(uname+"-----"+upwd+"------");
		
		if("ÕÅÈý".equals(uname)&&"123".equals(upwd))
		{
			
			//resp.sendRedirect("welcome?name="+URLEncoder.encode(URLEncoder.encode(uname,"utf-8"),"utf-8"));
			//resp.sendRedirect("welcome?name="+URLEncoder.encode(uname,"utf-8"));
			
			req.setAttribute("name", uname);
			RequestDispatcher rd=req.getRequestDispatcher("welcome");
			rd.forward(req,resp);
		}else 
		{
			resp.sendRedirect("login");
		}
		
		
		out.close();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	