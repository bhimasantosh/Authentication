package com.sbhima.auth.persistence.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbhima.auth.persistence.DataAccess;
import com.sbhima.auth.persistence.entity.User;

@Service
public class UserDAO {
	@Autowired
	private DataAccess dataAccess;

	public User saveOrUpdate(User user) throws Exception {
		return dataAccess.saveOrUpdate(user);
	}

	public User loadById(int id) throws Exception {
		return (User) dataAccess.loadById(User.class, id);
	}
}
