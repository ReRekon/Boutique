package com.servlet.core;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.Users;

public abstract class ServletBase extends HttpServlet 
{
	public abstract void excute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
	
	public void checkLoged(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		HttpSession hs=req.getSession();
        Users user=(Users)hs.getAttribute("loged");
        
        if(null==user) {
        	resp.sendRedirect("../index.html");
        	return ;
        }
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  req.setCharacterEncoding("utf-8");
		try {
			Method excute=this.getClass().getDeclaredMethod("excute", new Class[] {HttpServletRequest.class,HttpServletResponse.class});
			excute.invoke(this, new Object[] {req,resp});
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}





	//得到请求参数
    public String getString(HttpServletRequest req,String param)
    {
    	String value=null!=req.getParameter(param)?req.getParameter(param):"";
    	return value;
    }
    
    
    public int getInt(HttpServletRequest req,String param)
    {
    	int re=-1;
    	String str=this.getString(req, param);
    	if(str.matches("\\d+"))
    	{
    		re=Integer.parseInt(str);
    	}
    	return re;
    }
    //把请求参数填到obj对像对应的属性中
    public void getBean(HttpServletRequest req,Object obj)
    {
    	try {
			Class clazz=obj.getClass();
			Field all[]=clazz.getDeclaredFields();
			for(Field f:all)
			{
				f.setAccessible(true);
				String fname=f.getName();
				if(f.getType()==int.class)
				{
					f.set(obj, this.getInt(req, fname));
				}else if(f.getType()==String.class)
				{
					f.set(obj, this.getString(req, fname));
				}
			}
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
}
