package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {
	private Class clazz;
	@Resource
	private SessionFactory sessionFactory;
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	public T loadById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> loadByProperty(Object property, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	public T save(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> query() {
		// TODO Auto-generated method stub
		return null;
	}

	public T update(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	public T delete(T t) {
		// TODO Auto-generated method stub
		return null;
	}

}
