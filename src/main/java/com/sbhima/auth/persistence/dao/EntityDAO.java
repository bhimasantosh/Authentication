package com.sbhima.auth.persistence.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.sbhima.auth.persistence.DataAccess;
import com.sbhima.auth.persistence.entity.CommonEntity;
import com.sbhima.auth.persistence.entity.User;

@Service
public class EntityDAO {
	@Autowired
	private DataAccess dataAccess;

	@SuppressWarnings("rawtypes")
	public User saveOrUpdateSocialUser(CommonEntity entity) throws Exception {
		Object obj = dataAccess.saveOrUpdate(entity);
		Class clazz = obj.getClass();
		User user = (User) ReflectionUtils.invokeMethod(
				ReflectionUtils.findMethod(clazz, "getUser"), obj);
		return user;
	}
}
