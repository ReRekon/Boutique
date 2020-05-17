package com.oracle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		//req.setCharacterEncoding("utf-8");
		
		//String uanme=null!=req.getParameter("name")?req.getParameter("name"):"";
		
		out.println("<!DOCTYPE>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>ÓÃ»§µÇÂ¼</title>");
		out.println("</head>");
		out.println("<body>");
		
		String str=req.getParameter("uname");
		
		out.println("<h1>Welcome,"+str+"</h1>");
		out.println("</body>");
		out.println("</html>");
		
	}

	
}
