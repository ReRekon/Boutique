package com.oracle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		req.setCharacterEncoding("utf-8");
		
		HttpSession session=req.getSession();
		if(null==session.getAttribute("loged"))
		{
			resp.sendRedirect("login");
			return;
		}
		
		
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>用户登录</title>");
		out.println("</head>");
		out.println("<body>");
		
		// String name=null!=req.getParameter("name")?req.getParameter("name"):"";
		
		//out.println("<h1>Welcome,"+URLDecoder.decode(name,"utf-8")+"!</h1>");
		out.println("<h1>Welcome,"+req.getAttribute("name")+"!</h1>");
		out.println("<center><a href='login'>返回</a></center>");
		out.println("<center><a href='logout'>退出</a></center>");
		out.println("</body>");
		out.println("</html>");
	
		out.close();
	} 

}













