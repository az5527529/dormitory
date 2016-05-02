package com.controller.student;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.CheckOut;
import com.entity.SbRoom;
import com.entity.Student;
import com.service.sb.SbRoomService;
import com.service.student.CheckOutService;
import com.service.student.StudentService;
import com.util.StringUtil;
import com.util.WebUtil;

@Controller
@RequestMapping("/checkOut")
public class CheckOutController {
	@Resource
	private CheckOutService checkOutService;
	@Resource 
	private SbRoomService sbRoomService;
	@Resource
	private StudentService studentService;
	
	@RequestMapping(value = "/searchCheckOut", method = RequestMethod.POST)
	public void searchCheckOut(HttpServletRequest request,
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
		String sort = request.getParameter("sort");
		String order = request.getParameter("order");
		List<CheckOut> list = checkOutService.query(whereCondition,(page-1)*pageSize,pageSize,sort,order);
		JSONObject o = new JSONObject();
		o.put("total", checkOutService.getCount(whereCondition));
		o.put("rows", list);
		WebUtil.outputPage(request, response, o.toString());
	}
	
	@RequestMapping(value = "/doCheckOut", method = RequestMethod.POST)
	public void doCheckOut(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String msg="";
		JSONObject o = new JSONObject();
		String studentId = request.getParameter("studentId");
		String buildingNo = request.getParameter("buildingNo");
		String roomNo = request.getParameter("roomNo");
		SbRoom sbRoom = sbRoomService.getRoomByNo(buildingNo, roomNo);
		CheckOut checkOut = new CheckOut();
		try {
			BeanUtils.populate(checkOut, request.getParameterMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			o.put("errorMessage", e.getMessage());
		} 
		WebUtil.beforeSaveOrUpdate(request, checkOut, false);
		Student student = studentService.loadById(Long.parseLong(studentId));
		msg = checkOutService.doCheckOut(checkOut,student,sbRoom);
		
		if(msg.equals("登记成功")){
			o.put("msg", msg);
		}else{
			o.put("errorMessage", msg);
		}
		WebUtil.outputPage(request, response, o.toString());
	}
}
