package com.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.entity.UserInfo;

public class WebUtil {
	/**
	 * controller想view层返回信息的方法
	 * @param request
	 * @param response
	 * @param s
	 * @throws IOException
	 */
	public static void outputPage(HttpServletRequest request,HttpServletResponse response,String s) throws IOException{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter printwriter = response.getWriter();
		printwriter.print(s);
		printwriter.close();
	}
	/**
	 * 根据传进来的参数拼 hql的where条件
	 * @param request
	 * @return
	 */
	public static String getWhereCondition(HttpServletRequest request){
		StringBuilder condition = new StringBuilder();
		String fields = request.getParameter("fields");
		if(!StringUtil.isEmptyString(fields)){
			JSONObject json = JSONObject.fromObject(fields);
			 Iterator keyIter = json.keys();
			    String key;
			    String value;
			    while( keyIter.hasNext())
			    {
			        key = (String)keyIter.next();
			        value = (String)json.get(key);
			        if(!StringUtil.isEmptyString(value)){
			        	condition.append(" and "+key+"='"+value+"'");
			        }
			    } 
		}
		UserInfo userInfo = getUserInfo(request);
		if(userInfo.getRoleType()!=1){//当前用户不是超管时，只能看到所属楼的相关信息
			condition.append(" and buildingNo="+userInfo.getBuildingNo()+"");
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
	/**
	 * 新增前设置创建用户为当前登录用户
	 * @param request
	 * @param o
	 */
	@SuppressWarnings("unchecked")
	public static void beforeSave(HttpServletRequest request,Object o){
		try {
			Method method = o.getClass().getMethod("setCreatedByUser", String.class);
			method.invoke(o, getUserInfo(request).getUserName());
			/*Method method1 = o.getClass().getMethod("setBuildingNo", Integer.class);
			method1.invoke(o, getUserInfo(request).getBuildingNo());*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 更新前设置修改用户为当前登录用户
	 * @param request
	 * @param o
	 */
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
