package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
@WebServlet("/admin/upload")
public class UploadServlet extends HttpServlet 
{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Set factory constraints
		factory.setSizeThreshold(1024*1024*100);
		
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Set overall request size constraint
		upload.setSizeMax(1024*1024*20);
		out.println("<ul>");
		
			try {
				// Parse the request
				List<FileItem> items = upload.parseRequest(req);
				if(null!=items&&items.size()>0)
				{
					for(FileItem item:items)
					{
						if(item.isFormField())
						{
							//普通
							out.println("<li>普通表单</li>");
							String fileName=item.getFieldName();
							if(fileName.equals("dis"))
							{
								out.println("<li>文件描述："+item.getString("utf-8")+"</li>");
							}
							out.println();
						}else
						{
							//文件上传
							out.println("<li>文件上传-----------</li>");
							out.println("<li>ContentType:"+item.getContentType()+"</li>");
							out.println("<li>Size:"+item.getSize()+"</li>");
							out.println("<li>FieldName:"+item.getFieldName()+"</li>");
							out.println("<li>name:"+item.getName()+"</li>");
							
							String newname = randName()+getExtName(item.getName());
							out.println("<li>newname:"+newname+"</li>");
							File file=new File(this.getServletContext().getRealPath("ups")+File.separator+newname);
							
							item.write(file);
							
							out.println("<li>"+file+"</li>");
							
						}
						
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			out.println("</ul>");		
		
		
		
		out.close();
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
			SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			Random rand = new Random();
			return sf.format(new Date())+rand.nextInt(1000);
		}
}
