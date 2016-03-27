package com.service.student;

import com.entity.Student;
import com.service.common.BaseService;

public interface StudentService extends BaseService<Student> {
	public Student saveOrUpdate(Student student);
}
