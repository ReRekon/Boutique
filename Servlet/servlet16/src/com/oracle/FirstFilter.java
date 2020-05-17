package com.oracle;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstFilter implements Filter {
	FilterConfig fc;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("FirstFilter........destory...........");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("FirstFilter........doFilter...........");
		
		System.out.println("执行目标Servlet之前。。。。。。。。。。。。");
		
		arg2.doFilter(arg0, arg1);//把当前请求响应交给下一个目标。
		
		System.out.println("执行目标Servlet之后。。。。。。。。。。。。。");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("FirstFilter........init...........");
		this.fc=arg0;
	}

}
