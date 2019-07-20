package com.lanHan;
/**
 *	����ʽ (�ӳټ���)
 *	�����÷���ʱ�Ŵ���ʵ��
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
