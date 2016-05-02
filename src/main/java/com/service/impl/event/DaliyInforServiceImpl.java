package com.service.impl.event;

import org.springframework.stereotype.Service;

import com.entity.DaliyInfor;
import com.service.impl.common.BaseServiceImpl;
import com.service.event.DaliyInforService;

@Service("DaliyInforService")
public class DaliyInforServiceImpl extends BaseServiceImpl<DaliyInfor> implements
	DaliyInforService {
	
	public DaliyInfor createOrUpdate(DaliyInfor daliyInfor) {
		if(daliyInfor.getDailyInforId() > 0){
			return this.update(daliyInfor);
		}else{
			return this.save(daliyInfor);
		}
	}
	
}
