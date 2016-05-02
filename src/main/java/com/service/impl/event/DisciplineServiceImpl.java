package com.service.impl.event;

import org.springframework.stereotype.Service;

import com.entity.Discipline;
import com.service.impl.common.BaseServiceImpl;
import com.service.event.DisciplineService;

@Service("DisciplineService")
public class DisciplineServiceImpl extends BaseServiceImpl<Discipline> implements
	DisciplineService {
	
	public Discipline createOrUpdate(Discipline discipline) {
		if(discipline.getDisciplineId() > 0){
			return this.update(discipline);
		}else{
			return this.save(discipline);
		}
	}
	
}
