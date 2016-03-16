package com.service.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.A;
import com.service.TestSpringService;

@Service("testSpringService")
public class TestSpringServiceImpl implements TestSpringService{
	@Resource
	private SessionFactory sessionFactory;
	public void testSpring() {
		// TODO Auto-generated method stub
		System.out.println("spring测试");
	}
	
	@Transactional
	public void saveA(A a) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(a);
	}

}
