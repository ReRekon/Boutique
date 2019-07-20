package com.eHan;
/**
 *	饿汉式(立即加载)
 *	空间换取时间
 */
public class singleTon {
	
	private static singleTon instance=new singleTon();
	
	private singleTon() {
		
	}
	
	public singleTon getInstance() {
		return instance;
	}
	
	public static void main(String[] args) {
		
	}
}
