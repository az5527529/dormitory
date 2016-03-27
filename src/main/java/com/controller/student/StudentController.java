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
	public void searchStudent(HttpServletRequest request,
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
		Student student ;
		String id = request.getParameter("studentId");
		if(id!=null&&!id.equals("")){
			student = studentService.loadById(Long.parseLong(id));
		}else{
			student = new Student();
		}
		try {
			BeanUtils.populate(student, request.getParameterMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			o.put("errorMessage", e.getMessage());
		} 
		WebUtil.beforeSaveOrUpdate(request, student,student.getStudentId()>0?true:false);
		student = studentService.saveOrUpdate(student);
		o = JSONObject.fromObject(student);
		WebUtil.outputPage(request, response, o.toString());
	}
	
	@RequestMapping(value = "/searchById", method = RequestMethod.POST)
	public void searchById(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		Student student = studentService.loadById(Long.parseLong(id));
		JSONObject o = new JSONObject();
		if(student==null){
			o.put("errorMsg", "该学生不存在");
		}else{
			o = JSONObject.fromObject(student);
		}
		WebUtil.outputPage(request, response, o.toString());
	}
	
	@RequestMapping(value = "/deleteById", method = RequestMethod.POST)
	public void deleteById(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		int n = studentService.deleteById(Long.parseLong(id));
		JSONObject o = new JSONObject();
		if(n>0){
			o.put("msg", "删除成功");
			
		}else{
			o.put("msg", "删除失败");
		}
		WebUtil.outputPage(request, response, o.toString());
	}
}
