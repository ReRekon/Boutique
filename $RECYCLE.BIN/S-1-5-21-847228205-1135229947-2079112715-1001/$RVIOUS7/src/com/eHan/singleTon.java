package com.eHan;
/**
 *	����ʽ(��������)
 *	�ռ任ȡʱ��
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
