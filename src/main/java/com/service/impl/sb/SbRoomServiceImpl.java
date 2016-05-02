package com.service.impl.sb;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.entity.SbRoom;
import com.service.impl.common.BaseServiceImpl;
import com.service.sb.SbRoomService;
import com.util.CollectionUtil;

@Service("sbRoomService")
public class SbRoomServiceImpl extends BaseServiceImpl<SbRoom> implements
		SbRoomService {

	public SbRoom saveOrUpdate(SbRoom sbRoom) {
		// TODO Auto-generated method stub
		if(sbRoom.getSbRoomId()>0){
			if(sbRoom.getBedLeft()==0){
				sbRoom.setIsFull((byte) 1);
			}else{
				sbRoom.setIsFull((byte) 0);
			}
			return this.update(sbRoom);
		}else{
			sbRoom.setBedLeft(sbRoom.getBedNum());
			sbRoom.setIsFull((byte) 0);
			return this.save(sbRoom);
		}
	}

	public SbRoom getRoomByNo(String buildingNo, String roomNo) {
		// TODO Auto-generated method stub
		String hql = "from SbRoom where buildingNo=:buildingNo and roomNo=:roomNo";
		Query query = super.getSession().createQuery(hql);
		query.setString("buildingNo", buildingNo).setString("roomNo",roomNo);
		List<SbRoom> list = query.list();
		if(!CollectionUtil.isEmptyCollection(list)){
			SbRoom sbRoom= list.get(0);
			return sbRoom;
		}
		return null;
	}

}
