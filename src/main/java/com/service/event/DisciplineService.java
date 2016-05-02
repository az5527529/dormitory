package com.service.event;

import com.entity.Discipline;
import com.service.common.BaseService;

public interface DisciplineService extends BaseService<Discipline> {
	public Discipline createOrUpdate(Discipline discipline);
}
