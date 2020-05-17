package com.oracle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/randimg")
public class RandImageServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("image/png");
		ServletOutputStream os=resp.getOutputStream();
		
		BufferedImage img = new BufferedImage(120, 34, BufferedImage.TYPE_INT_BGR);
		Graphics g=img.getGraphics();
		g.setColor(new Color(220,220,220));
		g.fillRect(0, 0, 120, 34);
		
		Random rand = new Random();
		//画50条干扰线(随机)
		for(int i=0;i<50;i++)
		{
			g.setColor(new Color(160+rand.nextInt(30), 160+rand.nextInt(30), 200+rand.nextInt(30)));
			g.drawLine(rand.nextInt(120), rand.nextInt(34), rand.nextInt(120), rand.nextInt(34));
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<4;i++)
		{
			String str=randChar();
			sb.append(str);
			g.setColor(new Color(160+rand.nextInt(30), 80+rand.nextInt(30), 80+rand.nextInt(30)));
			g.setFont(new Font("宋体",Font.BOLD,26));
			g.drawString(str, 16+i*30, 20+rand.nextInt(5));
		}
		
		req.getSession().setAttribute("randcode", sb.toString());
		
		ImageIO.write(img, "png", os);
	}

	public String randChar()
	{
		int re=(int)((Math.random()*26)+65);
		return String.valueOf((char)re);
	}
	
}
