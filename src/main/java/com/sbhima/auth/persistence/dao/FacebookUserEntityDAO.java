package com.sbhima.auth.persistence.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbhima.auth.persistence.DataAccess;
import com.sbhima.auth.persistence.entity.FacebookUserEntity;

@Service
public class FacebookUserEntityDAO {
	@Autowired
	private DataAccess dataAccess;

	public FacebookUserEntity loadById(int id) throws Exception {
		return (FacebookUserEntity) dataAccess.loadById(
				FacebookUserEntity.class, id);
	}
}
