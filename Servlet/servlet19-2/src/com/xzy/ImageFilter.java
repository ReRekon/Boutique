package com.xzy;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/img/*")
public class ImageFilter implements Filter {

	@Override
	public void destroy() {

		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
	    System.out.println("@_@...............");
		HttpServletRequest req=(HttpServletRequest)arg0;
		HttpServletResponse resp=(HttpServletResponse)arg1;
		
		String refheader=req.getHeader("Referer");
		
		if(null!=refheader && refheader.indexOf("localhost")!=-1)
		{
			arg2.doFilter(req, resp);
		}else
		{
			resp.sendRedirect("../a8.jpg");
		}
		

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
