package com.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.UserInfo;

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
	
	public static void beforeSaveOrUpdate(HttpServletRequest request,Object o,boolean isUpdate){
		if(isUpdate){
			beforeUpdate(request,o);
		}else{
			beforeSave(request,o);
		}
	}
	@SuppressWarnings("unchecked")
	public static void beforeSave(HttpServletRequest request,Object o){
		try {
			Method method = o.getClass().getMethod("setCreatedByUser", String.class);
			method.invoke(o, getUserInfo(request).getUserName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void beforeUpdate(HttpServletRequest request,Object o){
		try {
			Method method = o.getClass().getMethod("setUpdatedByUser", String.class);
			method.invoke(o, getUserInfo(request).getUserName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static UserInfo getUserInfo(HttpServletRequest request){
		return (UserInfo) request.getSession().getAttribute("userInfo");
	}
}
