package com.oracle;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/*")
public class EncodingFilter implements Filter {

	FilterConfig fc;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		HttpServletRequest req=(HttpServletRequest) arg0;
		HttpServletResponse resp=(HttpServletResponse)arg1;
		String encode=null!=fc.getInitParameter("encode")?fc.getInitParameter("encode"):"utf-8";
		
		MyRequest myreq=new MyRequest(encode,req);
		
		arg2.doFilter(myreq, resp);//将请求响应交给目标
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		this.fc=arg0;
	}
	
	//内部类
	class MyRequest extends HttpServletRequestWrapper
	{
		private String encode;
		

		public MyRequest(String encode,HttpServletRequest request) {
			super(request);	
			this.encode=encode;
		}

		@Override
		public String getParameter(String name) 
		{
			String str=null;
			String org=super.getParameter(name);
			if(null!=org)
			{
				try {
					byte [] tem=org.getBytes("iso-8859-1");
					str=new String(tem,encode);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return str;
		}
	}

}
