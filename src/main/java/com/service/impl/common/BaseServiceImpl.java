package com.service.impl.common;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.MappedSuperclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.common.BaseService;
import com.util.CollectionUtil;

public class BaseServiceImpl<T> implements BaseService<T> {
	private Class clazz;
	@Autowired 
	private SessionFactory sessionFactory;
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	public BaseServiceImpl(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) type.getActualTypeArguments()[0];
	}
	public T loadById(long id) {
		// TODO Auto-generated method stub
		return (T) getSession().get(clazz, id);
	}

	public List<T> loadByProperty(String property, Object value) {
		// TODO Auto-generated method stub
		String hql = "from " + clazz.getSimpleName()+" where "+property+"='"+value+"'";
		return getSession().createQuery(hql).list();
	}

	@SuppressWarnings("unchecked")
	public T save(T t) {
		// TODO Auto-generated method stub
		return (T) getSession().save(t);
	}

	public List<T> query(String whereCondition,int pageStart,int pageSize) {
		// TODO Auto-generated method stub
		String hql = "from " + clazz.getSimpleName()+" where 1=1 "+whereCondition;
		return getSession().createQuery(hql).setFirstResult(pageStart).setMaxResults(pageSize).list();
	}

	public void update(T t) {
		// TODO Auto-generated method stub
		 getSession().update(t);;
	}

	public void delete(T t) {
		// TODO Auto-generated method stub
		getSession().delete(t);
	}
	public long getCount(String whereCondition) {
		// TODO Auto-generated method stub
		String hql = "from " + clazz.getSimpleName()+" where 1=1 "+whereCondition;
		List list = getSession().createQuery(hql).list();
		if(!CollectionUtil.isEmptyCollection(list)){
			return list.size();
		}
		return 0;
	}

}
