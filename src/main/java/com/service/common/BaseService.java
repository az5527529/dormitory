package com.service.common;

import java.util.List;

public interface BaseService<T> {
	
	public T loadById(long id);
	
	public List<T> loadByProperty(String property,Object value);
	
	public T save(T t);
	
	public List<T> query();
	
	public void update(T t);
	
	public void delete(T t);
}
