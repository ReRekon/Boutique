package com.oracle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		out.println("<title>用户登录</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<form action='checklogin' method='post'>");
		out.println("用户名:<input type='text' name='uname'/><br/>");
		out.println("密码:<input type='password' name='upwd'/><br/>");
		out.println("用户名:<input type='submit' value='登录'/><br/>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
		//out.close();
		
	}

}













