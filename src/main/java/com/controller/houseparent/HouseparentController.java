package com.controller.houseparent;

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

import com.entity.Houseparent;
import com.service.houseparent.HouseparentService;
import com.util.StringUtil;
import com.util.WebUtil;

@Controller
@RequestMapping("/houseparent")
public class HouseparentController {
	@Resource
	private HouseparentService houseparentService;
	
	@RequestMapping(value = "/searchHouseparent", method = RequestMethod.POST)
	public void login(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String whereCondition = WebUtil.getWhereCondition(request);
		String rowsStr = request.getParameter("rows");
		String pageStr = request.getParameter("page");
		int pageSize = 10;//默认分页大小
		int page = 1;
		
		if(!StringUtil.isEmptyString(rowsStr) && !StringUtil.isEmptyString(pageStr)){
			pageSize = Integer.parseInt(rowsStr);
			page = Integer.parseInt(pageStr);
		}

		String sort = request.getParameter("sort");
		String order = request.getParameter("order");
		List<Houseparent> list = houseparentService.query(whereCondition,(page-1)*pageSize,pageSize,sort,order);
		JSONObject o = new JSONObject();
		o.put("total", houseparentService.getCount(whereCondition));
		o.put("rows", list);
		WebUtil.outputPage(request, response, o.toString());
	}
	
	@RequestMapping(value = "/createOrUpdate", method = RequestMethod.POST)
	public void saveOrUpdate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		JSONObject o = new JSONObject();
		Houseparent houseparent;
		String id = request.getParameter("houseparentId");
		
		//通过id判断新建或修改
		if(id!=null && !id.equals("")){
			houseparent = houseparentService.loadById(Long.parseLong(id));
		}else{
			houseparent = new Houseparent();
		}
		
		try {
			BeanUtils.populate(houseparent, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
			o.put("errorMessage", e.getMessage());
		} 
		
		WebUtil.beforeSaveOrUpdate(request, houseparent,houseparent.getHouseparentId()>0?true:false);
		houseparent = houseparentService.createOrUpdate(houseparent);
		o = JSONObject.fromObject(houseparent);
		WebUtil.outputPage(request, response, o.toString());
	}
	
	@RequestMapping(value = "/searchById", method = RequestMethod.POST)
	public void searchById(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		Houseparent houseparent = houseparentService.loadById(Long.parseLong(id));
		JSONObject o = new JSONObject();
		
		if(houseparent == null){
			o.put("errorMsg", "该宿管不存在");
		}else{
			o = JSONObject.fromObject(houseparent);
		}
		
		WebUtil.outputPage(request, response, o.toString());
	}
	
	@RequestMapping(value = "/deleteById", method = RequestMethod.POST)
	public void deleteById(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		int n = houseparentService.deleteById(Long.parseLong(id));
		JSONObject o = new JSONObject();
		
		if(n > 0){
			o.put("msg", "删除成功");
		}else{
			o.put("msg", "删除失败");
		}
		
		WebUtil.outputPage(request, response, o.toString());
	}
}
