package com.xzy;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class HelloFilter implements Filter {

	public HelloFilter()
	{
		System.out.println("HelloFilter......................");
	}
	@Override
	public void destroy() {
		System.out.println("Hello destroy......................");

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("Hello doFilter....前..................");
		
       arg2.doFilter(arg0, arg1);//将请求和响应交给下一个资源
       
       System.out.println("Hello doFilter....后..................");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Hello init......................");
	
	}

}
