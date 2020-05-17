package com.oracle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
@WebServlet("/welcome01")
public class WelcomeServlet01 extends HttpServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException 
	{
		arg1.setContentType("text/html;charset=gbk");
		PrintWriter out=arg1.getWriter();
		out.println("<h1>÷ª÷ÿ–¥ public service </h1>");
		out.close();
	}
	
}
