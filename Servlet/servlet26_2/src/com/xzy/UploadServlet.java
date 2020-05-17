package com.xzy;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        req.setCharacterEncoding("utf-8");
     /*   ServletInputStream   sis=req.getInputStream();
        FileOutputStream fo=new FileOutputStream("c:\\up.txt");
       IOUtils.copy(sis, fo);*/
        out.println("<h1>读客户端数据完成，请查看e:\\up.txt</h1>");
        
       String str=req.getParameter("dis");
       
       out.println("<h2>dis:"+str+"</h1>");
       
       Part par=req.getPart("pic");
       
       out.println("<h2>getContentType:"+par.getContentType()+"</h2>");
       out.println("<h2>getSize:"+par.getSize()+"</h2>");
       out.println("<h2>header:"+par.getHeader("Content-Disposition")+"</h2>"); 
       out.println("<h2>getName:"+par.getName()+"</h2>");
       out.println("<h2>FileName:"+this.getFileName(par)+"</h2>");
       String newname=randName()+this.getExtName(this.getFileName(par));
       out.println("<h2>newName:"+newname+"</h2>");
       ServletContext sc=this.getServletContext();
       String path=sc.getRealPath("ups");
       
       out.println("<h2>newName:"+path+File.separator+newname+"</h2>");
       par.write(path+File.separator+newname);
       // out.println("<h2>getName:"+par.getName()+"</h2>");par.write(path+File.separator+"hi.txt");
       
       
       try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

       File f=new File(path);
       String allfile[]=f.list();
       out.println("<ul>");
       for(String file:allfile)
       {
    	   out.println("<li>"+file+"</li>");
       }
       out.println("</ul>");
        out.close();
        
	}
	//得到文件名
	public String getFileName(Part part)
	{
		String re=null;
		if(null!=part)
		{
			String allhead=part.getHeader("Content-Disposition");
			Pattern pattern=Pattern.compile("(form-data; name=\"(.*?)\"; filename=\"(.*?)\")");
			Matcher mac=pattern.matcher(allhead);
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
