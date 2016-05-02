package com.service.houseparent;

import com.entity.Houseparent;
import com.service.common.BaseService;

public interface HouseparentService extends BaseService<Houseparent> {

	public Houseparent createOrUpdate(Houseparent houseparent);
	
}
