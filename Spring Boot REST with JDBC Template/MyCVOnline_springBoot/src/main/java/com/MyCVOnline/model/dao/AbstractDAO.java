package com.MyCVOnline.model.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAO<T> {

	private final Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	} 

	@Autowired
	private SessionFactory factory;

	protected Session getSession() {
		return factory.getCurrentSession();
	}

	public T getByID(String key) {
		return (T) getSession().find(persistentClass, (Serializable) key);
	}

	public void save(T entity) {
		getSession().save(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}

	protected Criteria createEntityCriteria() {
		return getSession().createCriteria(persistentClass);
	}
}
