package com.lanHan;
/**
 *	懒汉式 (延迟加载)
 *	当调用方法时才创建实例
 */
public class singleTon {

	private static singleTon instance=null;
	
	private singleTon() {
		
	}
	
	public static singleTon getInstance() {
		if(null==instance) {
			instance=new singleTon();
		}
		return instance;
	}
	
	public static void main(String[] args) {
		singleTon instance1=new singleTon();
		System.out.println(instance1.getInstance().hashCode());
		
		singleTon instance2=new singleTon();
		System.out.println(instance2.getInstance().hashCode());
		
	}
	
}
