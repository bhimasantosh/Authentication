package com.sbhima.auth.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbhima.auth.persistence.dao.EntityDAO;
import com.sbhima.auth.persistence.entity.CommonEntity;
import com.sbhima.auth.persistence.entity.User;

@Service
public class EntityService {
	@Autowired
	private EntityDAO entityDAO;
	
	@Transactional(readOnly = false)
	public User saveOrUpdateSocialUser(CommonEntity entity) throws Exception {
		return entityDAO.saveOrUpdateSocialUser(entity); 
	}
}
