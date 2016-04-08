package com.controller.sb;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.SbRoom;
import com.service.sb.SbRoomService;
import com.util.StringUtil;
import com.util.WebUtil;

@Controller
@RequestMapping("/sbRoom")
public class SbRoomController {
	@Resource
	private SbRoomService sbRoomService;
	@RequestMapping(value = "/searchSbRoom", method = RequestMethod.POST)
	public void searchSbRoom(HttpServletRequest request,
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
		List<SbRoom> list = sbRoomService.query(whereCondition,(page-1)*pageSize,pageSize,sort,order);
		JSONObject o = new JSONObject();
		o.put("total", sbRoomService.getCount(whereCondition));
		o.put("rows", list);
		WebUtil.outputPage(request, response, o.toString());
	}
	
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public void saveOrUpdate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		JSONObject o = new JSONObject();
		SbRoom sbRoom ;
		String id = request.getParameter("sbRoomId");
		if(id!=null&&!id.equals("")){
			sbRoom = sbRoomService.loadById(Long.parseLong(id));
		}else{
			sbRoom = new SbRoom();
		}
		try {
			BeanUtils.populate(sbRoom, request.getParameterMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			o.put("errorMessage", e.getMessage());
		} 
		WebUtil.beforeSaveOrUpdate(request, sbRoom,sbRoom.getSbRoomId()>0?true:false);
		sbRoom = sbRoomService.saveOrUpdate(sbRoom);
		o = JSONObject.fromObject(sbRoom);
		WebUtil.outputPage(request, response, o.toString());
	}
	
	@RequestMapping(value = "/searchById", method = RequestMethod.POST)
	public void searchById(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		SbRoom sbRoom = sbRoomService.loadById(Long.parseLong(id));
		JSONObject o = new JSONObject();
		if(sbRoom==null){
			o.put("errorMsg", "该房间不存在");
		}else{
			o = JSONObject.fromObject(sbRoom);
		}
		WebUtil.outputPage(request, response, o.toString());
	}
	
	@RequestMapping(value = "/deleteById", method = RequestMethod.POST)
	public void deleteById(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		int n = sbRoomService.deleteById(Long.parseLong(id));
		JSONObject o = new JSONObject();
		if(n>0){
			o.put("msg", "删除成功");
			
		}else{
			o.put("msg", "删除失败");
		}
		WebUtil.outputPage(request, response, o.toString());
	}
}
