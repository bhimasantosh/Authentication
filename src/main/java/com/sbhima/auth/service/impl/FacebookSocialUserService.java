package com.sbhima.auth.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbhima.auth.persistence.entity.CommonEntity;
import com.sbhima.auth.persistence.entity.FacebookUserEntity;
import com.sbhima.auth.persistence.entity.User;
import com.sbhima.auth.persistence.service.UserService;
import com.sbhima.auth.service.ISocialUserService;
import com.sbhima.auth.service.constants.SocialType;
import com.sbhima.auth.social.facebook.dto.FacebookUser;

@Service
public class FacebookSocialUserService implements ISocialUserService {
	@Autowired
	private UserService userService;

	@Override
	public int getSocialType() {
		return SocialType.FACEBOOK.getValue();
	}

	@Override
	public String getSocialEmail(Serializable serializable) {
		FacebookUser facebookUser = (FacebookUser) serializable;
		return facebookUser.getEmail();
	}

	@Override
	public void populateUserEntity(CommonEntity commonEntity) throws Exception {
		FacebookUserEntity facebookUserEntity = (FacebookUserEntity) commonEntity;
		User user = userService.loadUserByEmail(facebookUserEntity.getUser()
				.getEmail(), SocialType.FACEBOOK.getValue());
		if (user != null) {
			facebookUserEntity.setUser(user);
		}
	}
}
