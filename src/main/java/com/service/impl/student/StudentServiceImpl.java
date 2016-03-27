package com.service.impl.student;

import org.springframework.stereotype.Service;

import com.entity.Student;
import com.service.impl.common.BaseServiceImpl;
import com.service.student.StudentService;

@Service("studentService")
public class StudentServiceImpl extends BaseServiceImpl<Student> implements
		StudentService {

	public Student saveOrUpdate(Student student) {
		// TODO Auto-generated method stub
		if(student.getStudentId()>0){
			 return this.update(student);
		}else{
			return this.save(student);
		}
	}

}
