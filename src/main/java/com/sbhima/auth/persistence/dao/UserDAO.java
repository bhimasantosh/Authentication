package com.sbhima.auth.persistence.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@SuppressWarnings("rawtypes")
	public User loadUserByEmail(String email, int socialType) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("email", email);
		params.put("socialType", socialType);
		List list = dataAccess
				.queryWithParams(
						new StringBuffer(
								"from User user where user.email=:email and user.socialType=:socialType"),
						params);
		return (User) list.get(0);
	}
}
