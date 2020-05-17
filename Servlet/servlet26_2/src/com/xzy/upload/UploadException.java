package com.xzy.upload;
/**
 * 上传文件时的异常
 * @author Administrator
 *
 */
public class UploadException extends Exception {
	
	//0正常，1类型不允许,2超过大小
private int types=0;

   public UploadException(int typs,String msg)
   {
	   super(msg);
	   this.types=types;
   }

public int getTypes() {
	return types;
}

public void setTypes(int types) {
	this.types = types;
}
   
}
