package com.xzy;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig
@WebServlet("/admin/upload")
public class UploadServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        req.setCharacterEncoding("utf-8");
     /*   ServletInputStream   sis=req.getInputStream();
        FileOutputStream fo=new FileOutputStream("c:\\up.txt");
       IOUtils.copy(sis, fo);*/
        out.println("<h1>读客户端数据完成，请查看c:\\up.txt</h1>");
        
       String str=req.getParameter("dis");
       
       out.println("<h2>dis:"+str+"</h1>");
       
       Part par=req.getPart("pic");
       
       out.println("<h2>getContentType:"+par.getContentType()+"</h2>");
       out.println("<h2>getSize:"+par.getSize()+"</h2>");
       out.println("<h2>header:"+par.getHeader("Content-Disposition")+"</h2>"); 
       out.println("<h2>getName:"+par.getName()+"</h2>");
       ServletContext sc=this.getServletContext();
       String path=sc.getRealPath("ups");
       
       par.write(path+File.separator+"hi.txt");
       
       
        out.close();
	}

}
