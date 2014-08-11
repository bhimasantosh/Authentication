package com.sbhima.auth.controller.service;

import java.util.List;

import com.sbhima.auth.social.dto.SocialProfile;

public interface ISocialConnectHandlerService {
	/**
	 * Return the social connections or friends for the current user given his
	 * access token
	 * 
	 * @param accessToken
	 * @return
	 * @throws Exception
	 */
	List<SocialProfile> getSocialFriends(int userId) throws Exception;
}
