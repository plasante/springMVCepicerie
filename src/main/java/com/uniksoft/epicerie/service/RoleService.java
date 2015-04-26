package com.uniksoft.epicerie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniksoft.epicerie.dao.GenericCrudDao;
import com.uniksoft.epicerie.domain.Role;

@Service
@Transactional
public class RoleService {

	@Autowired
	private GenericCrudDao<Role> entityDao;
	
	public List<Role> getAllEntities() {
		return entityDao.getAllEntities(Role.class);
	}
}
