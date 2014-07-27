package com.sbhima.auth.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbhima.auth.persistence.dao.UserDAO;
import com.sbhima.auth.persistence.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDAO userDAO;

	@Transactional(readOnly = false)
	public User saveOrUpdate(User user) throws Exception {
		return userDAO.saveOrUpdate(user);
	}

	@Transactional(readOnly = true)
	public User loadById(int id) throws Exception {
		return userDAO.loadById(id);
	}

	@Transactional(readOnly = false)
	public User loadUserByEmail(String email, int socialType) throws Exception {
		return userDAO.loadUserByEmail(email, socialType);
	}
}
