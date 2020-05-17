package com.xzy;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyServletRequest extends HttpServletRequestWrapper {

	HttpServletRequest req;
	
	public MyServletRequest(HttpServletRequest request) {
		super(request);
		this.req=request;
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getParameter(String name) {
		
		String str=null!=req.getParameter(name)?req.getParameter(name):"";
		return str;
	}
	
	

}
