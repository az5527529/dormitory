package com.service.student;

import com.entity.Student;
import com.service.common.BaseService;

public interface StudentService extends BaseService<Student> {
	public void saveOrUpdate(Student student,boolean isUpdate);
}
