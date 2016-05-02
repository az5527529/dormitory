package com.controller.event;

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

import com.entity.Postcard;
import com.service.event.PostcardService;
import com.util.StringUtil;
import com.util.WebUtil;

@Controller
@RequestMapping("/postcard")
public class PostcardController {
	@Resource
	private PostcardService postcardService;
	@RequestMapping(value = "/searchPostcard", method = RequestMethod.POST)
	public void searchPostcard(HttpServletRequest request,
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
		List<Postcard> list = postcardService.query(whereCondition,(page-1)*pageSize,pageSize,sort,order);
		JSONObject o = new JSONObject();
		o.put("total", postcardService.getCount(whereCondition));
		o.put("rows", list);
		WebUtil.outputPage(request, response, o.toString());
	}
	
	@RequestMapping(value = "/createOrUpdate", method = RequestMethod.POST)
	public void saveOrUpdate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		JSONObject o = new JSONObject();
		Postcard postcard ;
		String id = request.getParameter("postcardId");
		if(id!=null&&!id.equals("")){
			postcard = postcardService.loadById(Long.parseLong(id));
		}else{
			postcard = new Postcard();
		}
		try {
			BeanUtils.populate(postcard, request.getParameterMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			o.put("errorMessage", e.getMessage());
		} 
		WebUtil.beforeSaveOrUpdate(request, postcard,postcard.getPostcardId()>0?true:false);
		postcard = postcardService.createOrUpdate(postcard);
		o = JSONObject.fromObject(postcard);
		WebUtil.outputPage(request, response, o.toString());
	}
	
	@RequestMapping(value = "/searchById", method = RequestMethod.POST)
	public void searchById(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		Postcard postcard = postcardService.loadById(Long.parseLong(id));
		JSONObject o = new JSONObject();
		if(postcard==null){
			o.put("errorMsg", "该信息不存在");
		}else{
			o = JSONObject.fromObject(postcard);
		}
		WebUtil.outputPage(request, response, o.toString());
	}
	
	@RequestMapping(value = "/deleteById", method = RequestMethod.POST)
	public void deleteById(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		int n = postcardService.deleteById(Long.parseLong(id));
		JSONObject o = new JSONObject();
		if(n>0){
			o.put("msg", "删除成功");
			
		}else{
			o.put("msg", "删除失败");
		}
		WebUtil.outputPage(request, response, o.toString());
	}
}
