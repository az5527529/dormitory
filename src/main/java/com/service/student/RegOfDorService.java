package com.service.student;

import java.util.List;

import net.sf.json.JSONObject;

/**
 * 查看宿舍变更登记
 * @author victor
 *
 */
public interface RegOfDorService {
	public List searchRegister(JSONObject whereCondition,int pageStart,int pageSize,String orderBy, String order);
	
	public long getCount(JSONObject whereCondition);
}
