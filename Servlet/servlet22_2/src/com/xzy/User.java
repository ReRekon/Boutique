package com.xzy;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener{
   private String name;
   private String pwd;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
@Override
public void valueBound(HttpSessionBindingEvent arg0) {
	  System.out.println("将对像增加到了Session中...."+arg0.getName()+"--"+arg0.getValue());
	
}
@Override
public void valueUnbound(HttpSessionBindingEvent arg0) {
	  System.out.println("将对像从Session中移聊...."+arg0.getName()+"--"+arg0.getValue());
	
}
   
   
}
