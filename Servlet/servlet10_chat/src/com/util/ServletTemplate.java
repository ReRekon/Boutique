package com.util;

import java.io.BufferedReader;
import java.io.FileReader;

public class ServletTemplate 
{
   private static String orghtml="D:\\develop\\hbuilder_workspace2\\ajs\\chat.html";
   
   public static void main(String[] args) throws Exception
   {
	   BufferedReader br=new BufferedReader(new FileReader(orghtml));
	   
	   String str=null;
	   while(null!=(str=br.readLine()))
	   {
		   String newrow="out.println(\""+str.replaceAll("\"", "'")+"\");";
		   System.out.println(newrow);
	   }
	   
	   
	   br.close();
   }
   
}
