package com.service.sb;

import com.entity.SbRoom;
import com.service.common.BaseService;

public interface SbRoomService extends BaseService<SbRoom> {
	public SbRoom saveOrUpdate(SbRoom sbRoom);
	/**
	 * 根据楼号跟房号获取房
	 * @return
	 */
	public SbRoom getRoomByNo(String buildingNo,String roomNo);
}
