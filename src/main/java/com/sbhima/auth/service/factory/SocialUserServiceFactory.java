package com.sbhima.auth.service.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbhima.auth.service.ISocialUserService;
import com.sbhima.auth.service.constants.SocialConstants;
import com.sbhima.auth.service.constants.SocialType;
import com.sbhima.auth.service.impl.FacebookSocialUserService;

@Service
public class SocialUserServiceFactory {
	@Autowired
	private FacebookSocialUserService facebookSocialUserService;

	public ISocialUserService getSocialUserService(int socialType) {
		if (socialType == SocialType.FACEBOOK.getValue()) {
			return facebookSocialUserService;
		}
		return null;
	}

	public ISocialUserService getSocialUserService(String socialType) {
		if (socialType.equalsIgnoreCase(SocialConstants.FACEBOOK.getValue())) {
			return facebookSocialUserService;
		}
		return null;
	}
}
