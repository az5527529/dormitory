package com.service.student;

import com.entity.ChangeRoom;
import com.entity.SbRoom;
import com.entity.Student;
import com.service.common.BaseService;

public interface ChangeRoomService extends BaseService<ChangeRoom> {
	public ChangeRoom saveOrUpdate(ChangeRoom changeRoom);
	
	public String changeRoom(ChangeRoom changeRoom,Student student,SbRoom startSbRoom,SbRoom endSbRoom);
}
