package com.sbhima.auth.service.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbhima.auth.service.ISocialService;
import com.sbhima.auth.service.constants.SocialType;
import com.sbhima.auth.service.impl.FacebookSocialService;

@Service
public class SocialServiceFactory {
	@Autowired
	private FacebookSocialService facebookSocialService;

	public ISocialService getSocialService(String socialType) {
		if (socialType.equalsIgnoreCase(SocialType.FACEBOOK.getValue())) {
			return facebookSocialService;
		}
		return null;
	}
}
