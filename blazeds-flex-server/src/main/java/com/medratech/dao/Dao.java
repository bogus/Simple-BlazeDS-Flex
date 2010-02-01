package com.medratech.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface Dao<T, PK extends Serializable> {
	
	public T findById(Class clazz, Long id);
	
	public List<T> findAll();
	
	public T persist(T entity);
	
	public void flush();

	public void clear();

	public void remove(T entity);
}
