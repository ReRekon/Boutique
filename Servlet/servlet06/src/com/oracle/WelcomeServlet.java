package com.oracle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/welcome")
public class WelcomeServlet extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) 
			throws ServletException, IOException 
	{
		//服务器告诉客户端,我给你的数据是gbk
		arg1.setContentType("text/html;charset=gbk");
		PrintWriter pw=arg1.getWriter();
		
		//服务器读取客户端请求报体的编码
		//arg0.setCharacterEncoding("utf-8");
		String uname=null!=arg0.getParameter("uname")?arg0.getParameter("uname"):"";
	
		byte [] tem=uname.getBytes();
		String newname=new String(tem,"utf-8");
		
		pw.println("<h1>Welcome,"+uname+"</h1>");
		pw.close();

	}

}
