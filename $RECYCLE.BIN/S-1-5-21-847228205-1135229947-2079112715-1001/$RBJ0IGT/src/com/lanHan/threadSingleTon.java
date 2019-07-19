package com.lanHan;
/**
 *	�̰߳�ȫ������ʽ
 *	˫�ؼ�����
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
