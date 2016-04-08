package com.service.impl.sb;

import org.springframework.stereotype.Service;

import com.entity.SbBuilding;
import com.service.impl.common.BaseServiceImpl;
import com.service.sb.SbBuildingService;

@Service("sbBuildingService")
public class SbBuildingServiceImpl extends BaseServiceImpl<SbBuilding> implements
		SbBuildingService {

	public SbBuilding saveOrUpdate(SbBuilding sbBuilding) {
		// TODO Auto-generated method stub
		if(sbBuilding.getSbBuildingId()>0){
			return this.update(sbBuilding);
		}else{
			return this.save(sbBuilding);
		}
	}

}
