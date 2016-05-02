package com.service.impl.event;

import org.springframework.stereotype.Service;

import com.entity.Interview;
import com.service.impl.common.BaseServiceImpl;
import com.service.event.InterviewService;

@Service("InterviewService")
public class InterviewServiceImpl extends BaseServiceImpl<Interview> implements
	InterviewService {
	
	public Interview createOrUpdate(Interview interview) {
		if(interview.getInterviewId() > 0){
			return this.update(interview);
		}else{
			return this.save(interview);
		}
	}
	
}
