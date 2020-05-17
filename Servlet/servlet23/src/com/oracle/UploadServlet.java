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
@MultipartConfig  //才会把文件上传域帮你封装为Part对象
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		Part part = req.getPart("pic");
		

		 out.println("<h1>接收数据成功!</h1>"); 
		 out.println("<ul>");
		 out.println("<li>普通表单项:"+req.getParameter("des")+"</li>");
		 out.println("<li>文件类型:"+part.getContentType()+"</li>");
		 out.println("<li>表单项名:"+part.getName()+"</li>");
		 out.println("<li>文件大小:"+part.getSize()+"</li>");
		 out.println("<li>读报头:"+part.getHeader("Content-Disposition")+"</li>");
		 out.println("<li>文件原始名:"+this.getFileName(part)+"</li>");
		 
		 String path=this.getServletContext().getRealPath("ups");
		 String all=path+randName()+this.getExtName(this.getFileName(part));
		 out.println("<li>上传后的路径:"+all+"</li>");
		 
		 part.write(all);
		 out.println("</ul>");
		 
		out.close();
	}
		//得到文件名
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

		//得到扩展名
		public String getExtName(String fname)
		{
			String ex=null;
			if(null!=fname&&fname.lastIndexOf(".")!=-1)
			{
				ex=fname.toLowerCase().substring(fname.lastIndexOf("."));
			}
			
			return ex;
		}
		//随机生成文件名
		public String randName()
		{
			SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmmssSSS");
			Random rand=new Random();
			return sf.format(new Date())+rand.nextInt(1000);
		}
}
