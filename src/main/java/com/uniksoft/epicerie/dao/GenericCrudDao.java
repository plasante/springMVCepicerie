package com.uniksoft.epicerie.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericCrudDao<T> {
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public T getEntityById(Class<T> entity, Integer entityId) {
		String className = entity.getSimpleName();
		Session session = sessionFactory.getCurrentSession();
		List<T> entities = session.createQuery("from " + className + " e where e.id = :entityId")
								  .setParameter("entityId", entityId)
								  .list();
		return entities.size() == 1 ? (T)entities.get(0) : null;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAllEntities(Class<T> entity) {
		String className = entity.getSimpleName();
		return sessionFactory.getCurrentSession().createQuery("from " + className).list();
	}
	
	public void addEntity(T entity) {
		sessionFactory.getCurrentSession().save(entity);
	}
	
	public void updateEntity(T entity) {
		sessionFactory.getCurrentSession().update(entity);
	}
	
	@SuppressWarnings("unchecked")
	public void deleteEntity(Class<T> entity, Integer entityId) {
		T ent = (T)sessionFactory.getCurrentSession().load(entity, entityId);
		if (ent != null) {
			sessionFactory.getCurrentSession().delete(ent);
		}
	}
}
