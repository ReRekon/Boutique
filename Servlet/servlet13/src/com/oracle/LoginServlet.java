package com.oracle;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value="/login",name="looog")
public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>�û���¼</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		
		
		
		  Cookie [] all=req.getCookies(); String cokvalue=null;
		  if(null!=all &&all.length>0)
		  { 
			  for(Cookie cookie : all) 
			  {
				  if("uname".equals(cookie.getName()))
				  { 
					  cokvalue=URLDecoder.decode(cookie.getValue(), "gbk");
					  break; 
					 } 
				 } 
		  }
		 
		
		
		out.println("<form action='checklogin' method='post'>");
		
		if(null==cokvalue)
			out.println("�û���:<input type='text' name='uname' /><br/>");
		else
			out.println("�û���:<input type='text' name='uname' value='"+cokvalue+"'/><br/>");
			out.println("����:<input type='password' name='upwd'/><br/>");
		out.println("�û���:<input type='submit' value='��¼'/><br/>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
		//out.close();
		
	}

}













