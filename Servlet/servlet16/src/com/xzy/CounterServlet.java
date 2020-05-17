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
@WebServlet("/counter")
public class CounterServlet extends HttpServlet 
{
	int haha=100;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setContentType("text/html;charset=utf-8");
		 req.setCharacterEncoding("utf-8");
		 PrintWriter out=resp.getWriter();
		 //这个网页被访问过多少次  
		 ServletContext sc=this.getServletContext();
		 Integer totalcounter=(Integer)sc.getAttribute("totalcounter");
		 if(null==totalcounter)totalcounter=1;
		 out.println("<h1>这个网页被访问过"+(totalcounter++)+"次</h1>");
		 sc.setAttribute("totalcounter", totalcounter);
		 
		 //这个网页被多少人访问过
		 HttpSession hs=req.getSession();
		 Integer percount=(Integer)hs.getAttribute("percount");
		 
		 
		 Integer totalperson=(Integer)sc.getAttribute("totalperson");
		 if(null==totalperson) {totalperson=1; }
		 
		 if(null==percount) 
		 {totalperson++; percount=1; }
		 else
		 {
			 percount++ ;
		 }
		
		 out.println("<h1>这个网页被"+(totalperson)+"人访问过</h1>");
		 
		 //你是第几次访问这个页面
		 out.println("<h1>你是第"+percount+"次访问这个页面</h1>");
		 
		 out.println("<h1>ip:....."+req.getRemoteAddr()+"</h1>");
		 
		 
		 out.println("<h1>^_^:"+(haha++)+"</h1>");
		 
		 hs.setAttribute("percount", percount);
		 sc.setAttribute("totalperson", totalperson);
		 out.close();
	}

}
