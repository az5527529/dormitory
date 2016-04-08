package com.controller.sb;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.SbBuilding;
import com.service.sb.SbBuildingService;
import com.util.StringUtil;
import com.util.WebUtil;

@Controller
@RequestMapping("/sbBuilding")
public class SbBuildingController {
	@Resource
	private SbBuildingService sbBuildingService;
	@RequestMapping(value = "/searchSbBuilding", method = RequestMethod.POST)
	public void searchSbBuilding(HttpServletRequest request,
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
		List<SbBuilding> list = sbBuildingService.query(whereCondition,(page-1)*pageSize,pageSize,sort,order);
		JSONObject o = new JSONObject();
		o.put("total", sbBuildingService.getCount(whereCondition));
		o.put("rows", list);
		WebUtil.outputPage(request, response, o.toString());
	}
	
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public void saveOrUpdate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		JSONObject o = new JSONObject();
		SbBuilding sbBuilding ;
		String id = request.getParameter("sbBuildingId");
		if(id!=null&&!id.equals("")){
			sbBuilding = sbBuildingService.loadById(Long.parseLong(id));
		}else{
			sbBuilding = new SbBuilding();
		}
		try {
			BeanUtils.populate(sbBuilding, request.getParameterMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			o.put("errorMessage", e.getMessage());
		} 
		WebUtil.beforeSaveOrUpdate(request, sbBuilding,sbBuilding.getSbBuildingId()>0?true:false);
		sbBuilding = sbBuildingService.saveOrUpdate(sbBuilding);
		o = JSONObject.fromObject(sbBuilding);
		WebUtil.outputPage(request, response, o.toString());
	}
	
	@RequestMapping(value = "/searchById", method = RequestMethod.POST)
	public void searchById(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		SbBuilding sbBuilding = sbBuildingService.loadById(Long.parseLong(id));
		JSONObject o = new JSONObject();
		if(sbBuilding==null){
			o.put("errorMsg", "该楼不存在");
		}else{
			o = JSONObject.fromObject(sbBuilding);
		}
		WebUtil.outputPage(request, response, o.toString());
	}
	
	@RequestMapping(value = "/deleteById", method = RequestMethod.POST)
	public void deleteById(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		int n = sbBuildingService.deleteById(Long.parseLong(id));
		JSONObject o = new JSONObject();
		if(n>0){
			o.put("msg", "删除成功");
			
		}else{
			o.put("msg", "删除失败");
		}
		WebUtil.outputPage(request, response, o.toString());
	}
	
	@RequestMapping(value = "/combobox", method = RequestMethod.POST)
	public void combobox(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String whereCondition = WebUtil.getWhereCondition(request);
		List<SbBuilding> list = sbBuildingService.query(whereCondition,0,10000,"buildingNo","asc");
		SbBuilding sbBuilding = new SbBuilding();
		JSONArray o = JSONArray.fromObject(list);
		WebUtil.outputPage(request, response, o.toString());
	}
}
