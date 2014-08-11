package com.sbhima.auth.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbhima.auth.persistence.dao.FacebookFriendsDAO;
import com.sbhima.auth.persistence.entity.FacebookFriends;

@Service
public class FacebookFriendsService {
	@Autowired
	private FacebookFriendsDAO facebookFriendsDAO;

	@Transactional(readOnly = false)
	public void saveOrUpdate(FacebookFriends facebookFriends) throws Exception {
		facebookFriendsDAO.saveOrUpdate(facebookFriends);
	}
}
