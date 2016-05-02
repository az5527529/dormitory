package com.controller.student;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.ChangeRoom;
import com.service.student.RegOfDorService;
import com.util.StringUtil;
import com.util.WebUtil;

@Controller
@RequestMapping("/regOfDor")
public class RegOfDorController {
	@Resource
	private RegOfDorService regOfDorService;
	
	@RequestMapping(value = "/searchRegOfDor", method = RequestMethod.POST)
	public void searchRegOfDor(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		JSONObject whereCondition=new JSONObject();
		StringBuilder condition = new StringBuilder();
		String fields = request.getParameter("fields");
		if(!StringUtil.isEmptyString(fields)){
			whereCondition = JSONObject.fromObject(fields);
		}
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
		List<ChangeRoom> list = regOfDorService.searchRegister(whereCondition,(page-1)*pageSize,pageSize,sort,order);
		JSONObject o = new JSONObject();
		o.put("total", regOfDorService.getCount(whereCondition));
		o.put("rows", list);
		WebUtil.outputPage(request, response, o.toString());
	}
}
