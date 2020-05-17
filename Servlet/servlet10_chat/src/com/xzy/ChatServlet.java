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
@WebServlet("/chat")
public class ChatServlet extends HttpServlet 
{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out=resp.getWriter();
		
		String uname=null!=req.getParameter("uname")?req.getParameter("uname"):"";
		String msg=null!=req.getParameter("msg")?req.getParameter("msg"):"";
		
		ServletContext sc = this.getServletContext();
	    List<String> lines = (List<String>)sc.getAttribute("msgs");
	    
	    if(null==lines) 
	    {
	    	lines=new ArrayList<String>();
	    	sc.setAttribute("msgs", lines);
	    }
	    
		if(msg.length()>0 && uname.length()>0)
	    {
	    	lines.add(uname+":"+msg);
	    	sc.setAttribute("msgs", lines);
	    }
		
        if(uname.length()>0)
		{
			 out.println("<!DOCTYPE html>");
			 out.println("<html>");
			 out.println("<head>");
			 out.println("<meta charset='UTF-8'>");
			 out.println("<title>聊天室</title>");
			 out.println("<style type='text/css'>");
			 out.println("		#container{width: 800px; height: 600px; border:1px #CCC solid; margin: 0 auto;}");
			 out.println("		#main{ height: 540px; background: #e9e9e9;}");
			 out.println("</style>");
			 out.println("</head>");
			 out.println("<body>");
			 out.println("		<div id='container'>");
			 out.println("			  <div id='main'>");
			 out.println("			  	<iframe src='chatshow' width='100%' height='100%' marginheight='0' marginwidth='0' frameborder='0' framespacing='0'></iframe>");
			 out.println("			  </div>");
			 out.println("			  <div>");
			 out.println("			  	 <form action='chat' method='post'>");
			 out.println("			  	 <input type='hidden' name='uname' value='"+uname+"'/>");
			 out.println("			  	 "+uname+"<input type='text' name='msg'  style='width: 400px;'/>"
			 		                     +"<input type='submit' value='send' /> ");
			 out.println("			  	 </form>");
			 out.println("			  </div>");
			 out.println("		</div>");
			 out.println("</body>");
			 out.println("</html>");

		 }else
		 {
			out.println("<script>alert('请输入用户名!');history.back(-1);</script>"); 
		 }
		 
		 out.close();
	}

}
