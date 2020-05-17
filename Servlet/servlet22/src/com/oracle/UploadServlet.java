package com.oracle;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig  //才会把文件上传域帮你封装为Part对象
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		//接收客户端的所有数据，并保存在d:\\up.txt
		/*
		 * PrintWriter pw = new PrintWriter("d:\\up.txt"); ServletInputStream
		 * is=req.getInputStream(); BufferedReader br=new BufferedReader(new
		 * InputStreamReader(is)); String str=null;
		 * 
		 * while(null != (str=br.readLine())) { pw.println(str); } br.close();
		 * pw.close();
		 */
		
		Part part = req.getPart("pic");
		
		out.println("<h1>接收数据成功!</h1>");
		out.println("<ul>");
		out.println("<li>普通表单项:"+req.getParameter("des")+"</li>");
		out.println("<li>文件类型:"+part.getContentType()+"</li>");
		out.println("<li>表单项名:"+part.getName()+"</li>");
		out.println("<li>文件大小:"+part.getSize()+"</li>");
		out.println("<li>读报头:"+part.getHeader("Content-Disposition")+"</li>");
		
		part.write("e:\\up.txt");
		
		out.println("</ul>");
		out.close();
	}

	
}
