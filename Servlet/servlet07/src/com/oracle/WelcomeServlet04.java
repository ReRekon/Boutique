package com.oracle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/welcome04")
public class WelcomeServlet04 extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		   resp.setContentType("text/html;charset=gbk");
		   PrintWriter out=resp.getWriter();
		  
		   resp.addHeader("hello", "welcome");
		   resp.setHeader("Server", "iis6.0");
		   
		   out.println("<h1>"+resp.getStatus()+"</h1>");
		   
		   //resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		  // resp.sendError(500,"服务器正忙....");
		  
		   //有问题！！！！！！！！！！！！！！！！！
		   
		   //重定向到百度
		  resp.setStatus(302);
		  resp.addHeader("Location", "http://www.baidu.com");
		   //等价于27  28 行
		  //sendRedirect("http://www.google.com");
		   
		//   out.println("<h1>Welcome 04</h1>");
		   
		 //  out.close();
	}

}









