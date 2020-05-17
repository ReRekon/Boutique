package com.xzy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/checkLogin")
public class CheckLoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		req.setCharacterEncoding("utf-8");
		String str=req.getParameter("name");
		
		User user=new User();
		user.setName(str);
		
		HttpSession hs=req.getSession();
		hs.setAttribute("loged", user);
		
		
		req.getRequestDispatcher("userlist").forward(req, resp);
		
		out.close();
	}

}
