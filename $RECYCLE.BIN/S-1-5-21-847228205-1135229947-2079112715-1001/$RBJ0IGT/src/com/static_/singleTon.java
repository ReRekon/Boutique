package com.static_;
/**
 *	ʹ�þ�̬�ڲ���ʵ��
 *	
 */
public class singleTon {
	
	private static class singleTonHoler{
		/**
		 * ��̬��ʼ��������JVM��֤��ȫ
		 * ���౻װ�ز���ʼ����ʱ����ʼ�����ľ�̬�򣬾�̬��ֻ�������װ�����ʱ���ʼ��һ�Σ����������֤�̰߳�ȫ
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
