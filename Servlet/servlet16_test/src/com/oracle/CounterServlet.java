package com.oracle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;
@WebServlet("/counter")
public class CounterServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out=resp.getWriter();
		
		//这个页面被访问过多少次
		
		ServletContext sc = this.getServletContext();
		Integer totalcounter=(Integer)sc.getAttribute("totalcounter");
		if(null==totalcounter)
		{
			totalcounter=1;
		}
		out.println("<h1>这个页面被访问了"+(totalcounter++)+"次.</h1>");
		sc.setAttribute("totalcounter", totalcounter);
		
		//这个页面有几个人访问过
		//你是第几次访问这个页面
		
		HttpSession hs = req.getSession();
		Integer person = (Integer)hs.getAttribute("person");
		
		Integer percounte = (Integer)sc.getAttribute("percounte");

		if(null==percounte)
		{
			percounte=0;
		}
		
		if(null==person)
		{
			person=1;
			percounte++ ;
		}else {
			person++ ;
		}
		
		out.println("<h1>共有"+percounte+"人访问过此页面.</h1>");
		out.println("<h1>你是第"+person+"次访问此页面.</h1>");
		
		sc.setAttribute("percounte", percounte);
		hs.setAttribute("person", person);
		
		out.close();
	}

	
}
