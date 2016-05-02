package com.service.student;

import com.entity.CheckIn;
import com.entity.SbRoom;
import com.entity.Student;
import com.service.common.BaseService;

public interface CheckInService extends BaseService<CheckIn> {
	public CheckIn saveOrUpdate(CheckIn checkIn);
	
	public String checkIn(CheckIn checkIn,Student student,SbRoom sbRoom);
}
