package com.service.impl.student;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.CheckIn;
import com.entity.SbRoom;
import com.entity.Student;
import com.service.impl.common.BaseServiceImpl;
import com.service.sb.SbRoomService;
import com.service.student.CheckInService;
import com.service.student.StudentService;
import com.util.WebUtil;

@Service("CheckInService")
public class CheckInServiceImpl extends BaseServiceImpl<CheckIn> implements
		CheckInService {
	@Resource 
	private SbRoomService sbRoomService;
	@Resource
	private StudentService studentService;
	public CheckIn saveOrUpdate(CheckIn checkIn) {
		// TODO Auto-generated method stub
		if(checkIn.getCheckInId()>0){
			return this.update(checkIn);
		}else{
			return this.save(checkIn);
		}
	}
	public String checkIn(CheckIn checkIn, Student student, SbRoom sbRoom) {
		// TODO Auto-generated method stub
		
		if(sbRoom==null){
			return "所选房间不存在";
		}
		checkIn = this.saveOrUpdate(checkIn);
		int bedLeft = sbRoom.getBedLeft()-1;
		sbRoom.setBedLeft(bedLeft);
		sbRoomService.saveOrUpdate(sbRoom);
		student.setIsCheckIn((byte)1);
		student.setBuildingNo(sbRoom.getBuildingNo());
		student.setRoomNo(sbRoom.getRoomNo());
		studentService.saveOrUpdate(student);
		return "登记成功";
	}


}
