package com.xzy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/userlist")
public class UserListServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
	    
		out.println("<h1>用户列表.....<a href='logout'>退出</a></h1>");
		out.println("<h3>当前在线"+User.alluser.size()+"人</h3>");
		out.println("<ul>");
		for(User user:User.alluser)
		out.println("<li>"+user.getName()+"</li>");
		 
		out.println("</ul>");
		out.close();
	}

}
