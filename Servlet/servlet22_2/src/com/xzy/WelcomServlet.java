package com.xzy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/wel")
public class WelcomServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		req.setCharacterEncoding("utf-8");
		String str=req.getParameter("uname");
		out.println("<h1>Welcome,"+str+"</h1>");
		
		
		ServletContext sc=this.getServletContext();
		sc.setAttribute("aa", "bb");
		sc.setAttribute("aa", "cc");
		sc.removeAttribute("aa");
		
		
		req.setAttribute("xx", "bb");
		req.setAttribute("xx", "cc");
		req.removeAttribute("xx");
		
		User user=new User();
		user.setName(str);
		
		HttpSession hs=req.getSession();
		hs.setAttribute("loguser", user);//回调user对象中的valueBound
		hs.removeAttribute("loguser");//回调user对象中的valueUnbound
		
		out.close();
	}

}
