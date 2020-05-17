package com.xzy;

import java.util.Date;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
@WebListener
public class RequstLis implements ServletRequestAttributeListener, ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
	       System.out.println("销毁了Reqeust对像--------"+arg0.getServletRequest()+"----------"+new Date());
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		  System.out.println("创建了Reqeust对像--------"+arg0.getServletRequest()+"----------"+new Date());

	}

	@Override
	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		 System.out.println("Reqeust对像---中增加了-----"+arg0.getName()+"----------"+arg0.getValue());

	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		 System.out.println("Reqeust对像---中删除了-----"+arg0.getName()+"----------"+arg0.getValue());

	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		 System.out.println("Reqeust对像---中替换了-----"+arg0.getName()+"----------"+arg0.getValue());

	}

}
