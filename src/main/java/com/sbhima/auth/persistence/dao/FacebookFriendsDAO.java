package com.sbhima.auth.persistence.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbhima.auth.persistence.DataAccess;
import com.sbhima.auth.persistence.entity.FacebookFriends;

@Service
public class FacebookFriendsDAO {
	@Autowired
	private DataAccess dataAccess;
	public  void saveOrUpdate(FacebookFriends facebookFriends) throws Exception {
		dataAccess.saveOrUpdate(facebookFriends);
	}
}
