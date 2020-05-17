package com.xzy;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyResponse extends HttpServletResponseWrapper {

	HttpServletResponse resp;
	String path;
	public MyResponse(HttpServletResponse response,String path) {
		super(response);
		// TODO Auto-generated constructor stub
		this.resp=response;
		this.path=path;
	}
	@Override
	public void sendError(int sc, String msg) throws IOException {
		// TODO Auto-generated method stub
		//super.sendError(sc, msg);
		if(sc==404)
		{
			resp.setStatus(200);
			resp.sendRedirect(path+"error404.html");
		}
		System.out.println("-------------sendError 2----");
	}
	@Override
	public void sendError(int sc) throws IOException {
		// TODO Auto-generated method stub
		super.sendError(sc);
		System.out.println("-------------sendError 1----");
	}

	@Override
	public void setStatus(int sc) {
		// TODO Auto-generated method stub
		super.setStatus(sc);
		System.out.println("-------------setStatus----");
	}
	
	

}
