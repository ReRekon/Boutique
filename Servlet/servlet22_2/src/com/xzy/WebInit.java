package com.xzy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
/**
 * 监听ServletContext 对像的创建与销毁
 * @author Administrator
 *
 */
@WebListener
public class WebInit implements ServletContextListener,ServletContextAttributeListener {

	ServletContext sc=null;
	PrintWriter pw=null;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("销毁ServletContext.........");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) 
	{
		System.out.println("初始化ServletContext.........");
		sc=arg0.getServletContext();
		try {
			pw=new PrintWriter(sc.getRealPath("logs")+File.separator+"mylog.log");
		    pw.println("创建了ServletContext...."+new Date());
		    pw.flush();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		 System.out.println("在ServletContext中增加了东西"+arg0.getName()+"--"+arg0.getValue());
		 pw.println("在ServletContext中增加了东西"+arg0.getName()+"--"+arg0.getValue());
		 pw.flush();
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		 System.out.println("在ServletContext中删除了东西"+arg0.getName()+"--"+arg0.getValue());
		 pw.println("在ServletContext中删除了东西"+arg0.getName()+"--"+arg0.getValue());
		 pw.flush();
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		 System.out.println("在ServletContext中替换了东西"+arg0.getName()+"--"+arg0.getValue());
		 pw.println("在ServletContext中替换了东西"+arg0.getName()+"--"+arg0.getValue());
		 pw.flush();
	}

}
