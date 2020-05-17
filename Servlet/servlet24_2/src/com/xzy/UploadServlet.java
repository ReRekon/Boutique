package com.xzy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

@WebServlet("/admin/upload")
public class UploadServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        
        ServletInputStream   sis=req.getInputStream();
        FileOutputStream fo=new FileOutputStream("c:\\up.txt");
       IOUtils.copy(sis, fo);
        out.println("<h1>读客户端数据完成，请查看c:\\up.txt</h1>");
        
        out.close();
	}

}
