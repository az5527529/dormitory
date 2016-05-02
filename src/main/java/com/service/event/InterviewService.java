package com.service.event;

import com.entity.Interview;
import com.service.common.BaseService;

public interface InterviewService extends BaseService<Interview> {
	public Interview createOrUpdate(Interview interview);
}
