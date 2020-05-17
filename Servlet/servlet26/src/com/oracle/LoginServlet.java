package com.oracle;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
		out.println("<title>用户登录</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<ul>");
		
		
		HttpSession hs=req.getSession();
		hs.setMaxInactiveInterval(60*10);
		out.println("<li> isNew:"+hs.isNew()+"</li>");
		out.println("<li> ID:"+hs.getId()+"</li>");
		out.println("<li> 创建时间:"+new Date(hs.getCreationTime())+"</li>");
		out.println("<li> 访问时间:"+new Date(hs.getLastAccessedTime())+"</li>");
		out.println("<li> 过期时间:"+hs.getMaxInactiveInterval()+"</li>");
		
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
		 
		out.println("</ul>");
		
		out.println("<form action='checklogin' method='post'>");
		
		if(null==cokvalue)
			out.println("用户名:<input type='text' name='uname' /><br/>");
		else
			out.println("用户名:<input type='text' name='uname' value='"+cokvalue+"'/><br/>");
			out.println("密码:<input type='password' name='upwd'/><br/>");
		out.println("用户名:<input type='submit' value='登录'/><br/>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
		//out.close();
		
	}

}













