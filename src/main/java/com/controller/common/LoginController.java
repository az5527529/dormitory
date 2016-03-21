package com.controller.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.UserInfo;
import com.service.common.LoginService;
import com.util.WebUtil;

@Controller
@RequestMapping("/loginExt")
public class LoginController {
	@Resource
	private LoginService loginService;
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(@RequestParam(value = "userCode", required = true) String userCode,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "checkCode", required = true) String checkCode,HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		UserInfo userInfo = null;
		String randCheckCode = (String)request.getSession().getAttribute("randCheckCode");
		if(!randCheckCode.equalsIgnoreCase(checkCode)){
			userInfo = new UserInfo();
			userInfo.setErrorMsg("验证码错误");
		}else{
			userInfo = loginService.login(userCode, password,request);
		}
		request.getSession().removeAttribute("randCheckCode");
		JSONObject object = JSONObject.fromObject(userInfo);
		WebUtil.outputPage(request, response, object.toString());
	}
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public void login(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("userInfo");
		session.removeAttribute("groupList");
		WebUtil.outputPage(request, response, "");
	}
}
