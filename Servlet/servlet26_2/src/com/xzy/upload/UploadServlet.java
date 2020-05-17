package com.xzy.upload;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig
@WebServlet("/up/up/up")
public class UploadServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
			try {
				List<UpResult> re=FileUploadUtils.uploadFile(req.getParts(),this.getServletContext().getRealPath("ups"),".jpg,.png,.gif",1024*1204*5);
			} catch (UploadException e) {
				switch (e.getTypes()) {
				case 1:
					
					break;
                 case 2:
					
					break;
				default:
					break;
				}
				e.printStackTrace();
			}
		
	}

}
