package com.sbhima.auth.controller.handlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbhima.auth.controller.service.ISocialConnectHandlerService;
import com.sbhima.auth.persistence.entity.FacebookUserEntity;
import com.sbhima.auth.persistence.service.FacebookUserEntityService;
import com.sbhima.auth.service.impl.FacebookSocialService;
import com.sbhima.auth.social.dto.SocialProfile;

@Service
public class FacebookConnectHandler implements ISocialConnectHandlerService {
	@Autowired
	private FacebookSocialService facebookSocialService;
	@Autowired
	private FacebookUserEntityService facebookUserEntityService;

	@Override
	public List<SocialProfile> getSocialFriends(int userId) throws Exception {
		FacebookUserEntity facebookUserEntity = facebookUserEntityService
				.loadById(userId);
		return facebookSocialService
				.getUserSocialConnections(facebookUserEntity.getAccessToken());
	}
}
