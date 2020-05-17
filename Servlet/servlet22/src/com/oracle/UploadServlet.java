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
@MultipartConfig  //�Ż���ļ��ϴ�������װΪPart����
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		//���տͻ��˵��������ݣ���������d:\\up.txt
		/*
		 * PrintWriter pw = new PrintWriter("d:\\up.txt"); ServletInputStream
		 * is=req.getInputStream(); BufferedReader br=new BufferedReader(new
		 * InputStreamReader(is)); String str=null;
		 * 
		 * while(null != (str=br.readLine())) { pw.println(str); } br.close();
		 * pw.close();
		 */
		
		Part part = req.getPart("pic");
		
		out.println("<h1>�������ݳɹ�!</h1>");
		out.println("<ul>");
		out.println("<li>��ͨ����:"+req.getParameter("des")+"</li>");
		out.println("<li>�ļ�����:"+part.getContentType()+"</li>");
		out.println("<li>������:"+part.getName()+"</li>");
		out.println("<li>�ļ���С:"+part.getSize()+"</li>");
		out.println("<li>����ͷ:"+part.getHeader("Content-Disposition")+"</li>");
		
		part.write("e:\\up.txt");
		
		out.println("</ul>");
		out.close();
	}

	
}
