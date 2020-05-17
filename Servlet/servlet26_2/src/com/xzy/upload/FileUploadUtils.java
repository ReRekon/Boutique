package com.xzy.upload;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.Part;

public class FileUploadUtils 
{
	/**
	 * 上传文件，
	 * @param parts
	 * @param path  要上传到的绝对径
	 * @param allow  .jpg,.png,.gif,
	 * @param sizeLimit  最大不超过
	 * @return
	 * @throws UploadException
	 */
   public static List<UpResult> uploadFile(Collection<Part> parts,String path,String allow,long sizeLimit)throws UploadException
   {
	   return null;
   }
}
