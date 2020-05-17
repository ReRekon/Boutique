package com.oracle;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		
		Part part = req.getPart("pic");
		

		 out.println("<h1>�������ݳɹ�!</h1>"); 
		 out.println("<ul>");
		 out.println("<li>��ͨ����:"+req.getParameter("des")+"</li>");
		 out.println("<li>�ļ�����:"+part.getContentType()+"</li>");
		 out.println("<li>������:"+part.getName()+"</li>");
		 out.println("<li>�ļ���С:"+part.getSize()+"</li>");
		 out.println("<li>����ͷ:"+part.getHeader("Content-Disposition")+"</li>");
		 out.println("<li>�ļ�ԭʼ��:"+this.getFileName(part)+"</li>");
		 
		 String path=this.getServletContext().getRealPath("ups");
		 String all=path+randName()+this.getExtName(this.getFileName(part));
		 out.println("<li>�ϴ����·��:"+all+"</li>");
		 
		 part.write(all);
		 out.println("</ul>");
		 
		out.close();
	}
		//�õ��ļ���
		public String getFileName(Part part)
		{
			String re=null;
			if(null!=part)
			{
				String hv=part.getHeader("Content-Disposition");
				Pattern pattern=Pattern.compile("(form-data; name=\"(.*?)\"; filename=\"(.*?)\")");
				Matcher mac=pattern.matcher(hv);
				if(mac.find())
				{
					re=mac.group(3);
				}
			}
			
			return re;
		}

		//�õ���չ��
		public String getExtName(String fname)
		{
			String ex=null;
			if(null!=fname&&fname.lastIndexOf(".")!=-1)
			{
				ex=fname.toLowerCase().substring(fname.lastIndexOf("."));
			}
			
			return ex;
		}
		//��������ļ���
		public String randName()
		{
			SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
			Random rand=new Random();
			return sf.format(new Date())+rand.nextInt(1000);
		}
}
