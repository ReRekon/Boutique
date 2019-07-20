package com.lanHan;
/**
 *	线程安全的懒汉式
 *	双重检查加锁
 */
public class threadSingleTon {

	private volatile static threadSingleTon instance=null;
	
	private threadSingleTon() {
		
	}
	
	public threadSingleTon getInstance() {
		if(null==instance) {
			synchronized(threadSingleTon.class) {
					instance=new threadSingleTon();
				}
		}
		return instance;
	}
	
	public static void main(String[] args) {
		
	}

}
