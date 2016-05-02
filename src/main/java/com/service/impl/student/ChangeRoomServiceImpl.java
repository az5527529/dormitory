package com.service.impl.student;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.ChangeRoom;
import com.entity.SbRoom;
import com.entity.Student;
import com.service.impl.common.BaseServiceImpl;
import com.service.sb.SbRoomService;
import com.service.student.ChangeRoomService;
import com.service.student.StudentService;

@Service("changeRoomService")
public class ChangeRoomServiceImpl extends BaseServiceImpl<ChangeRoom>
		implements ChangeRoomService {

	@Resource
	private StudentService studentService;
	@Resource
	private SbRoomService sbRoomService;

	public ChangeRoom saveOrUpdate(ChangeRoom changeRoom) {
		// TODO Auto-generated method stub
		if(changeRoom.getChangeRoomId()!=null&&changeRoom.getChangeRoomId()>0){
			return super.update(changeRoom);
		}else{
			return super.save(changeRoom);
		}
	}
	/**
	 * 换房登记
	 */
	public String changeRoom(ChangeRoom changeRoom, Student student,
			SbRoom startSbRoom, SbRoom endSbRoom) {
		// TODO Auto-generated method stub
		changeRoom.setStartRoomId(startSbRoom.getSbRoomId());//设置原始房间
		changeRoom.setEndRoomId(endSbRoom.getSbRoomId());//设置换房后房间
		this.saveOrUpdate(changeRoom);//保存登记表
		int startBedLeft = startSbRoom.getBedLeft();

		startSbRoom.setBedLeft(startBedLeft+1);
		sbRoomService.saveOrUpdate(startSbRoom);
		int endBedLeft = endSbRoom.getBedLeft();
		endBedLeft--;
		endSbRoom.setBedLeft(endBedLeft);

		sbRoomService.saveOrUpdate(endSbRoom);
		student.setBuildingNo(endSbRoom.getBuildingNo());
		student.setRoomNo(endSbRoom.getRoomNo());
		studentService.saveOrUpdate(student);
		return "登记成功";
	}


}
