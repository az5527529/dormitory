package com.service.common;

import javax.servlet.http.HttpServletRequest;

import com.entity.SysUser;
import com.entity.UserInfo;

public interface LoginService extends BaseService<SysUser> {
	public UserInfo login(String userCode,String password,HttpServletRequest request);

}
