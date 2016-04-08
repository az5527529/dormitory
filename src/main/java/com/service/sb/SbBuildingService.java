package com.service.sb;

import com.entity.SbBuilding;
import com.service.common.BaseService;

public interface SbBuildingService extends BaseService<SbBuilding> {
	public SbBuilding saveOrUpdate(SbBuilding sbBuilding);
}
