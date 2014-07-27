package com.sbhima.auth.controller.handlers;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbhima.auth.persistence.entity.CommonEntity;
import com.sbhima.auth.service.ISocialService;
import com.sbhima.auth.service.factory.SocialServiceFactory;

@Service
public class SocialHttpHandler {
	@Autowired
	private SocialServiceFactory socialServiceFactory;

	public void authorizeSocialApplication(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		String socialType = httpServletRequest.getParameter("socialType");
		ISocialService socialService = socialServiceFactory
				.getSocialService(socialType);
		httpServletResponse.sendRedirect(socialService
				.getAuthorizationRedirectURL());
	}

	public String getAccessToken(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws HttpException,
			IOException {
		String code = httpServletRequest.getParameter("code");
		String socialType = httpServletRequest.getParameter("state");
		ISocialService socialService = socialServiceFactory
				.getSocialService(socialType);
		String accessToken = socialService.getAccessTokenResponse(code);
		return accessToken;
	}

	public Serializable getUserDetails(String socialType, String accessToken)
			throws Exception {
		ISocialService socialService = socialServiceFactory
				.getSocialService(socialType);
		return socialService.getUserDetails(accessToken);
	}

	public CommonEntity getUserFromSocialUser(Serializable socialUser,
			String accessToken, String socialType) {
		ISocialService socialService = socialServiceFactory
				.getSocialService(socialType);
		return socialService.getUserFromSocialUser(socialUser, accessToken);
	}
}
