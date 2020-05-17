package com.xzy;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener
{
	
   public static Vector<User> alluser=new Vector<User>();
	
	
  private String name;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

@Override
public void valueBound(HttpSessionBindingEvent arg0) 
{
	System.out.println(arg0.getValue()+"---"+arg0.getSession().getAttribute("loged"));
	if(arg0.getValue() instanceof User)
	{
		System.out.println("--------------.......................");
	alluser.add((User)arg0.getValue());	
	}
}

@Override
public void valueUnbound(HttpSessionBindingEvent arg0) {
	System.out.println(arg0.getValue()+"****"+arg0.getSession().getAttribute("loged"));
	if(arg0.getValue() instanceof User)
	{
		//alluser.remove((User)(arg0.getSession().getAttribute("loged")));
	User u=(User)(arg0.getValue());
	alluser.remove(arg0.getValue());
	}
  
	
}
  
}
