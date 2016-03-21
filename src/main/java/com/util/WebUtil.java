package com.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtil {
	public static boolean isEmptyCollection(Collection collection){
		if(collection==null||collection.isEmpty()){
			return true;
		}
		return false;
	}
	public static boolean isEmptyString(String str){
		if(str==null||str.trim().length()==0){
			return true;
		}
		return false;
	}
	public static void outputPage(HttpServletRequest request,HttpServletResponse response,String s) throws IOException{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter printwriter = response.getWriter();
		printwriter.print(s);
		printwriter.close();
	}
}
