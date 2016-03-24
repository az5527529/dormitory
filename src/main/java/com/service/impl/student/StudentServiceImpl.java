package com.service.impl.student;

import org.springframework.stereotype.Service;

import com.entity.Student;
import com.service.impl.common.BaseServiceImpl;
import com.service.student.StudentService;

@Service("studentService")
public class StudentServiceImpl extends BaseServiceImpl<Student> implements
		StudentService {

	public void saveOrUpdate(Student student, boolean isUpdate) {
		// TODO Auto-generated method stub
		if(isUpdate){
			 this.update(student);
		}else{
			this.save(student);
		}
	}

}
