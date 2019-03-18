package com.oracle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/regist")
public class RegistServlet extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) 
			throws ServletException, IOException 
	{
		arg1.setContentType("text/html;charset=utf-8");
		PrintWriter pw=arg1.getWriter();
		
		
		pw.println("<h1>用户注册</h1>");
		 
		
		java.util.Map<java.lang.String, java.lang.String[]> all=arg0.getParameterMap();
		
		pw.println("<h1>所有参数封装为Map</h1>");
		pw.println("<ul>");
		Iterator<String> it=all.keySet().iterator();
		while(it.hasNext())
		{
			String key=it.next();
			pw.println("<li>"+key+"="+Arrays.toString(all.get(key))+"</li>");
		}
		pw.println("</ul>");
		
		
		pw.println("<h1>相同参数时，多组值</h1>");
		String [] aihao=arg0.getParameterValues("ah");
		
		pw.println("<h2>"+Arrays.toString(aihao)+"</h2>");
		
		pw.println("<hr/>");
		pw.println("<h3>"+arg0.getLocalAddr()+"<h3/>");
		pw.println("<h3>"+arg0.getLocalPort()+"<h3/>");
		pw.println("<h3>"+arg0.getLocalName()+"<h3/>");
		
		
		
		pw.println("<h3>"+arg0.getRemoteAddr()+"<h3/>");
		pw.println("<h3>"+arg0.getRemoteHost()+"<h3/>");
		pw.println("<h3>"+arg0.getRemotePort()+"<h3/>");
		
		pw.close();

	}

}
