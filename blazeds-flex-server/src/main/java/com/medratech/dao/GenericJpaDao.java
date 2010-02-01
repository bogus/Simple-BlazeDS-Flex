package com.medratech.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.medratech.model.Model;
import com.medratech.model.impl.User;

public abstract class GenericJpaDao<T, PK extends Serializable> implements
		Dao<T, PK> {

	@PersistenceContext
	private EntityManager entityManager;

	protected Class<T> classType;

	@SuppressWarnings("unchecked")
	public GenericJpaDao() {
		this.classType = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public Class<T> getClassType() {
		return classType;
	}
	
	@SuppressWarnings("unchecked")
	public T findById(Class clazz, Long id) {
		return (T) getEntityManager().find(clazz, id);
	}

	public List<T> findAll() {
		@SuppressWarnings("unchecked")
		List<T> results = getEntityManager().createQuery(
				"select o from " + getClassType().getSimpleName() + " o")
				.getResultList();
		return results;
	}

	public T persist(T entity) {
		getEntityManager().persist(entity);
		return entity;
	}

	public void flush() {
		getEntityManager().flush();
	}

	public void clear() {
		getEntityManager().clear();
	}

	
	public void remove(T entity) {
		getEntityManager().remove(entity);
	}

}
