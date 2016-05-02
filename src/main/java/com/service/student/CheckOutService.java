package com.service.student;

import com.entity.CheckOut;
import com.entity.SbRoom;
import com.entity.Student;
import com.service.common.BaseService;

public interface CheckOutService extends BaseService<CheckOut> {
	public CheckOut saveOrUpdate(CheckOut checkOut);
	
	public String doCheckOut(CheckOut checkOut,Student student,SbRoom sbRoom);
}
