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

import com.entity.ChangeRoom;
import com.entity.CheckIn;
import com.entity.SbRoom;
import com.entity.Student;
import com.service.sb.SbRoomService;
import com.service.student.ChangeRoomService;
import com.service.student.StudentService;
import com.util.StringUtil;
import com.util.WebUtil;

@Controller
@RequestMapping("/changeRoom")
public class ChangeRoomController {
	@Resource
	private ChangeRoomService changeRoomService;
	@Resource 
	private SbRoomService sbRoomService;
	@Resource
	private StudentService studentService;
	
	@RequestMapping(value = "/searchChangeRoom", method = RequestMethod.POST)
	public void searchChangeRoom(HttpServletRequest request,
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
		List<ChangeRoom> list = changeRoomService.query(whereCondition,(page-1)*pageSize,pageSize,sort,order);
		JSONObject o = new JSONObject();
		o.put("total", changeRoomService.getCount(whereCondition));
		o.put("rows", list);
		WebUtil.outputPage(request, response, o.toString());
	}
	
	@RequestMapping(value = "/doChangeRoom", method = RequestMethod.POST)
	public void doChangeRoom(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String msg="";
		JSONObject o = new JSONObject();
		String studentId = request.getParameter("studentId");
		String startBuildingNo = request.getParameter("startBuildingNo");
		String startRoomNo = request.getParameter("startRoomNo");
		String buildingNo = request.getParameter("buildingNo");
		String roomNo = request.getParameter("roomNo");
		SbRoom startSbRoom = sbRoomService.getRoomByNo(startBuildingNo, startRoomNo);//获得原始房间
		SbRoom endSbRoom = sbRoomService.getRoomByNo(buildingNo, roomNo);//获得换房后房间
		ChangeRoom changeRoom = new ChangeRoom();
		try {
			BeanUtils.populate(changeRoom, request.getParameterMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			o.put("errorMessage", e.getMessage());
		} 
		WebUtil.beforeSaveOrUpdate(request, changeRoom, false);
		Student student = studentService.loadById(Long.parseLong(studentId));
		msg = changeRoomService.changeRoom(changeRoom,student,startSbRoom,endSbRoom);
		
		if(msg.equals("登记成功")){
			o.put("msg", msg);
		}else{
			o.put("errorMessage", msg);
		}
		WebUtil.outputPage(request, response, o.toString());
	}
}
