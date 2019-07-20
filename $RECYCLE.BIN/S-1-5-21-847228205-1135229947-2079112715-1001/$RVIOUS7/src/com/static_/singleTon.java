package com.static_;
/**
 *	使用静态内部类实现
 *	
 */
public class singleTon {
	
	private static class singleTonHoler{
		/**
		 * 静态初始化器，由JVM保证安全
		 * 该类被装载并初始化的时候会初始化它的静态域，静态域只在虚拟机装载类的时候初始化一次，由虚拟机保证线程安全
		 */
		private static singleTon instance=new singleTon();
	}
	
	private singleTon() {
		
	}
	
	private singleTon getInstance() {
		return singleTonHoler.instance;
	}
	
	public static void main(String[] args) {

	}

}
