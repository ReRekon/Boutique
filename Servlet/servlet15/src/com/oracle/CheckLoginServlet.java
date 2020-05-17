package com.oracle;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
		
		
		if("张三".equals(uname)&&"123".equals(upwd))
		{
			
			//resp.sendRedirect("welcome?name="+URLEncoder.encode(URLEncoder.encode(uname,"utf-8"),"utf-8"));
			//resp.sendRedirect("welcome?name="+URLEncoder.encode(uname,"utf-8"));
			
			
			 Cookie cookie = new Cookie("uname",URLEncoder.encode(uname,"gbk"));
			 cookie.setMaxAge(60*60*24*7); 
			 resp.addCookie(cookie);
			 
			HttpSession hs=req.getSession();
			hs.setAttribute("loged", "haha~~~~~~~");
			hs.setAttribute("name", uname);
			
			
			resp.sendRedirect(resp.encodeRedirectURL("welcome"));
		}else 
		{
			//resp.sendRedirect("login");
			out.println("CheckLogin 开始..............");
			RequestDispatcher rd=req.getRequestDispatcher("login");
			rd.include(req, resp);
			
			out.println("CkeckLogin 结束..............");
		}
		
		
		out.close();
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	