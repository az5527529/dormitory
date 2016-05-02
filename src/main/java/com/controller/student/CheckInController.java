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

import com.entity.CheckIn;
import com.entity.SbRoom;
import com.entity.Student;
import com.service.sb.SbRoomService;
import com.service.student.CheckInService;
import com.service.student.StudentService;
import com.util.StringUtil;
import com.util.WebUtil;

@Controller
@RequestMapping("/checkIn")
public class CheckInController {
	@Resource
	private CheckInService checkInService;
	@Resource 
	private SbRoomService sbRoomService;
	@Resource
	private StudentService studentService;
	@RequestMapping(value = "/searchCheckIn", method = RequestMethod.POST)
	public void searchCheckIn(HttpServletRequest request,
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
		List<CheckIn> list = checkInService.query(whereCondition,(page-1)*pageSize,pageSize,sort,order);
		JSONObject o = new JSONObject();
		o.put("total", checkInService.getCount(whereCondition));
		o.put("rows", list);
		WebUtil.outputPage(request, response, o.toString());
	}
	
	@RequestMapping(value = "/doCheckIn", method = RequestMethod.POST)
	public void doCheckIn(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String msg="";
		JSONObject o = new JSONObject();
		String studentId = request.getParameter("studentId");
		String buildingNo = request.getParameter("buildingNo");
		String roomNo = request.getParameter("roomNo");
		String checkInTime = request.getParameter("checkInTime");
		SbRoom sbRoom = sbRoomService.getRoomByNo(buildingNo, roomNo);
		CheckIn checkIn = new CheckIn();
		try {
			BeanUtils.populate(checkIn, request.getParameterMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			o.put("errorMessage", e.getMessage());
		} 
		WebUtil.beforeSaveOrUpdate(request, checkIn, false);
		Student student = studentService.loadById(Long.parseLong(studentId));
		msg = checkInService.checkIn(checkIn,student,sbRoom);
		
		if(msg.equals("登记成功")){
			o.put("msg", msg);
		}else{
			o.put("errorMessage", msg);
		}
		WebUtil.outputPage(request, response, o.toString());
	}
}
