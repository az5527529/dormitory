package com.service.impl.houseparent;

import org.springframework.stereotype.Service;

import com.entity.Houseparent;
import com.service.impl.common.BaseServiceImpl;
import com.service.houseparent.HouseparentService;

@Service("houseparentService")
public class HouseparentServiceImpl extends BaseServiceImpl<Houseparent> implements
		HouseparentService {
	
	public Houseparent createOrUpdate(Houseparent houseparent) {
		if(houseparent.getHouseparentId() > 0){
			return this.update(houseparent);
		}else{
			return this.save(houseparent);
		}
	}
	
}
