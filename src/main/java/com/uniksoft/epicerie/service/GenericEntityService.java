package com.uniksoft.epicerie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniksoft.epicerie.dao.GenericCrudDao;

@Service
@Transactional
public class GenericEntityService<T> {

	@Autowired
	private GenericCrudDao<T> entityDao;
	
	public T getEntityById(Class<T> entity, Integer entityId) {
		return entityDao.getEntityById(entity, entityId);
	}
	
	public List<T> getAllEntities(Class<T> entity) {
		return entityDao.getAllEntities(entity);
	}
	
	public void addEntity(T entity) {
		entityDao.addEntity(entity);
	}
	
	public void updateEntity(T entity) {
		entityDao.updateEntity(entity);
	}
	
	public void deleteEntity(Class<T> entity, Integer entityId) {
		entityDao.deleteEntity(entity, entityId);
	}
}
