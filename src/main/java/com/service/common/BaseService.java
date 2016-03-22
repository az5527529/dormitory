package com.service.common;

import java.util.List;

public interface BaseService<T> {
	
	public T loadById(long id);
	
	public List<T> loadByProperty(String property,Object value);
	
	public T save(T t);
	
	public List<T> query(String whereCondition,int pageStart,int pageSize);
	
	public long getCount(String whereCondition);
	
	public void update(T t);
	
	public void delete(T t);
}
