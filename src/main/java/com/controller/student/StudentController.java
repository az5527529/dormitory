package com.controller.student;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Student;
import com.service.student.StudentService;
import com.util.StringUtil;
import com.util.WebUtil;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Resource
	private StudentService studentService;
	@RequestMapping(value = "/searchStudent", method = RequestMethod.POST)
	public void login(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String whereCondition = WebUtil.getWhereCondition(request);
		String rowsStr = request.getParameter("rows");
		String pageStr=request.getParameter("page");
		int pageSize = 10;
		int page = 1;
		if(!StringUtil.isEmptyString(rowsStr)&&!StringUtil.isEmptyString(pageStr)){
			pageSize = Integer.parseInt(rowsStr);
			page = Integer.parseInt(pageStr);
		}
		List<Student> list = studentService.query(whereCondition,(page-1)*pageSize,pageSize);
		JSONObject o = new JSONObject();
		o.put("total", studentService.getCount(whereCondition));
		o.put("rows", list);
		WebUtil.outputPage(request, response, o.toString());
	}
	
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public void saveOrUpdate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		JSONObject o = new JSONObject();
		Student student = new Student();
		try {
			BeanUtils.populate(student, request.getParameterMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			o.put("errorMessage", e.getMessage());
		} 
		WebUtil.beforeSaveOrUpdate(request, student, Boolean.parseBoolean(request.getParameter("isUpdate")));
		studentService.saveOrUpdate(student, Boolean.parseBoolean(request.getParameter("isUpdate")));
		o.put("message", "保存成功");
		WebUtil.outputPage(request, response, o.toString());
	}
}
