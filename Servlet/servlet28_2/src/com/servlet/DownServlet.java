package com.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
@WebServlet("/down")
public class DownServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		String fname=null!=req.getParameter("fname")?req.getParameter("fname"):"";
		ServletContext sc=this.getServletContext();
		String mime=sc.getMimeType("ups/"+fname);
		System.out.println(mime+"-----------------------");
		
		resp.setContentType(mime);
		resp.setHeader("Content-Disposition", "attachment;filename="+fname);
		
		FileInputStream fi=new FileInputStream(sc.getRealPath("ups")+File.separator+fname);
		ServletOutputStream sos=resp.getOutputStream();
		//jspsmartupload
		IOUtils.copy(fi, sos);
		
	}

}
