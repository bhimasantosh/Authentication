package com.sbhima.auth.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbhima.auth.persistence.dao.FacebookUserEntityDAO;
import com.sbhima.auth.persistence.entity.FacebookUserEntity;

@Service
public class FacebookUserEntityService {
	@Autowired
	private FacebookUserEntityDAO facebookUserEntityDAO;

	@Transactional(readOnly = true)
	public FacebookUserEntity loadById(int id) throws Exception {
		return facebookUserEntityDAO.loadById(id);
	}
}
