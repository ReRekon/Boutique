package com.oracle;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
@WebFilter("/*")
public class FileNotFoundFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		HttpServletResponse resp=(HttpServletResponse) arg1;
		MyResponse myres=new MyResponse(resp);
		
		arg2.doFilter(arg0, myres);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	class MyResponse extends HttpServletResponseWrapper
	{

		public MyResponse(HttpServletResponse response) {
			super(response);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void sendError(int sc) throws IOException {
			if(sc==404)
			{
				this.setStatus(200);
				this.sendRedirect("http://localhost/servlet20/error.html");
			}
		}
 
		@Override
		public void sendError(int sc, String msg) throws IOException {
			if(sc==404)
			{
				this.setStatus(200);
				this.sendRedirect("http://localhost/servlet20/error.html");
			}
		}
		
		
	}
}
