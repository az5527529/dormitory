package com.service;

import java.util.List;

public interface BaseService<T> {
	
	public T loadById(long id);
	
	public List<T> loadByProperty(Object property,Object value);
	
	public T save(T t);
	
	public List<T> query();
	
	public T update(T t);
	
	public T delete(T t);
}
