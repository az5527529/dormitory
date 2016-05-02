package com.service.impl.student;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.CheckOut;
import com.entity.SbRoom;
import com.entity.Student;
import com.service.impl.common.BaseServiceImpl;
import com.service.sb.SbRoomService;
import com.service.student.CheckOutService;
import com.service.student.StudentService;

@Service("checkOutService")
public class CheckOutServiceImpl extends BaseServiceImpl<CheckOut> implements
		CheckOutService {
	@Resource
	private StudentService studentService;
	@Resource
	private SbRoomService sbRoomService;
	public CheckOut saveOrUpdate(CheckOut checkOut) {
		// TODO Auto-generated method stub
		if(checkOut.getCheckOutId()!=null&&checkOut.getCheckOutId()>0){
			return super.update(checkOut);
		}else{
			return super.save(checkOut);
		}
	}

	public String doCheckOut(CheckOut checkOut, Student student, SbRoom sbRoom) {
		// TODO Auto-generated method stub
		this.saveOrUpdate(checkOut);
		student.setIsCheckIn((byte) 0);
		student.setBuildingNo(0);
		student.setRoomNo(0);
		this.studentService.saveOrUpdate(student);
		sbRoom.setBedLeft(sbRoom.getBedLeft()+1);
		this.sbRoomService.saveOrUpdate(sbRoom);
		return "登记成功";
	}


}
