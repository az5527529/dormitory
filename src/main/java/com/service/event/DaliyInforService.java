package com.service.event;

import com.entity.DaliyInfor;
import com.service.common.BaseService;

public interface DaliyInforService extends BaseService<DaliyInfor> {
	public DaliyInfor createOrUpdate(DaliyInfor daliyInfor);
}
