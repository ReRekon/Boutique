package com.oracle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/welcome02")
public class WelcomeServlet02 extends HttpServlet {

	@Override
	public void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException 
	{
		arg1.setContentType("text/html;charset=gbk");
		PrintWriter out=arg1.getWriter();
		out.println("<h1>Ö»ÖØÐ´ public service-->"+arg0.getMethod()+"</h1>");
		out.close();
	}
	
}
