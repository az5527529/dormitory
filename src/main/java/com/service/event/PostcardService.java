package com.service.event;

import com.entity.Postcard;
import com.service.common.BaseService;

public interface PostcardService extends BaseService<Postcard> {
	public Postcard createOrUpdate(Postcard postcard);
}
