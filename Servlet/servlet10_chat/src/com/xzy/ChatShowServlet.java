package com.xzy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/chatshow")
public class ChatShowServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out=resp.getWriter();
		
		String msg=null!=req.getParameter("msg")?req.getParameter("msg"):"";
		String uname=null!=req.getParameter("uname")?req.getParameter("uname"):"";
		
		ServletContext sc=this.getServletContext();
		List<String> lines=(List<String>)sc.getAttribute("msgs");
		
	    if(null==lines) 	
	    {
	    	lines=new ArrayList<String>();
	    	sc.setAttribute("msgs", lines);
	    }
	    	//显示
	    	out.println("<!DOCTYPE html>");
	    	out.println("<html>");
	    	out.println("	<head>");
	    	out.println("<meta http-equiv=\"Refresh\" content=\"1;url=chatshow\" />");
	    	out.println("		<meta charset='UTF-8'>");
	    	out.println("		<title>聊天信息</title>");
	    	out.println("	</head>");
	    	out.println("	<body>");
	    	
	    	if(null!=lines)
		    	for(String row:lines)
		    	out.println("<p>"+row+"</p>");
		    	
	    	out.println("	</body>");
	    	out.println("</html>");
	    
	 


		out.close();
	
	}

}
