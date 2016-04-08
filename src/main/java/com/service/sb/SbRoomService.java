package com.service.sb;

import com.entity.SbRoom;
import com.service.common.BaseService;

public interface SbRoomService extends BaseService<SbRoom> {
	public SbRoom saveOrUpdate(SbRoom sbRoom);
}
