package com.service.impl.event;

import org.springframework.stereotype.Service;

import com.entity.Postcard;
import com.service.impl.common.BaseServiceImpl;
import com.service.event.PostcardService;

@Service("PostcardService")
public class PostcardServiceImpl extends BaseServiceImpl<Postcard> implements
	PostcardService {
	
	public Postcard createOrUpdate(Postcard postcard) {
		if(postcard.getPostcardId() > 0){
			return this.update(postcard);
		}else{
			return this.save(postcard);
		}
	}
	
}
