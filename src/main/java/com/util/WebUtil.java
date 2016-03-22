package com.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtil {
	public static void outputPage(HttpServletRequest request,HttpServletResponse response,String s) throws IOException{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter printwriter = response.getWriter();
		printwriter.print(s);
		printwriter.close();
	}
	public static String getWhereCondition(HttpServletRequest request){
		StringBuilder condition = new StringBuilder();
		Enumeration enu=request.getParameterNames();
		while(enu.hasMoreElements()){
			String property = (String) enu.nextElement();
			if(!property.equals("ids")&&!property.equals("rows")&&!property.equals("page")){
				String value = request.getParameter(property);
				if(!StringUtil.isEmptyString(value)){
					condition.append(" and "+property+"='"+value+"'");
				}
			}
			
		}
		
		return condition.toString();
	}
}
