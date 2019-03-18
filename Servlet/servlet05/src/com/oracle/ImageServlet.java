package com.oracle;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/hello.jpg")
public class ImageServlet extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) 
			throws ServletException, IOException 
	{
		arg1.setContentType("image/jpg");
		ServletOutputStream os = arg1.getOutputStream();
		
		BufferedImage img=new BufferedImage(400, 300, BufferedImage.TYPE_INT_BGR);
		java.awt.Graphics g=img.getGraphics();
		g.setColor(Color.orange);
		g.fillRect(0, 0, 400, 300);
		
		
		g.setColor(Color.white);
		g.drawLine(100, 100, 300, 300);
		
		
		g.setFont(new Font("Î¢ÈíÑÅºÚ",Font.BOLD,28));
		g.drawString("´ó¼ÒºÃ", 200, 200);
		
		ImageIO.write(img, "png", os);
	}

}
