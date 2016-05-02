package com.service.impl.student;

import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.service.student.RegOfDorService;
import com.util.StringUtil;

@Service("regOfDorService")
public class RegOfDorServiceImpl implements RegOfDorService {

	public List searchRegister(JSONObject whereCondition, int pageStart,
			int pageSize, String orderBy, String order) {
		// TODO Auto-generated method stub
		String timeStart = whereCondition.getString("timeStart");
		String timeEnd = whereCondition.getString("timeEnd");
		String registType = whereCondition.getString("registType");
		String buildingNo = whereCondition.getString("buildingNo");
		StringBuilder condition = new StringBuilder();
		StringBuilder sql = new StringBuilder();
		if(StringUtil.isEmptyString(registType)){
			sql.append("(select student_id studentId,'入住登记' registType,reason reason,time time,created_By_User createdByUser,\n")
			   .append("rome_id startRoom,rome_id endRoom \n")
			   .append("from check_in where 1=1")
			   .append(condition)
			   .append(") ci \n")
			   ;
		}
		
		return null;
	}
	public long getCount(JSONObject whereCondition) {
		// TODO Auto-generated method stub
		
		return 0;
	}
}
