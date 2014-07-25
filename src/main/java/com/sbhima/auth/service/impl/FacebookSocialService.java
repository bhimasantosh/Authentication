package com.sbhima.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbhima.auth.service.ISocialService;
import com.sbhima.auth.service.constants.OAuthAppConstants;
import com.sbhima.auth.service.constants.SocialType;
import com.sbhima.auth.service.properties.FacebookApplicationProperties;
import com.sbhima.auth.service.properties.SocialEndpointProperties;

@Service
public class FacebookSocialService implements ISocialService {
	@Autowired
	private FacebookApplicationProperties facebookApplicationProperties;
	@Autowired
	private SocialEndpointProperties socialEndpointProperties;

	@Override
	public String getAuthorizationRedirectURL() {
		StringBuilder url = new StringBuilder();
		url.append(socialEndpointProperties.getProperty(SocialType.FACEBOOK
				.getValue() + ".endpoint"));
		url.append("?");
		String clientId = facebookApplicationProperties
				.getProperty(SocialType.FACEBOOK.getValue() + "."
						+ OAuthAppConstants.CLIENT_ID.getValue());
		String redirectUri = facebookApplicationProperties
				.getProperty(SocialType.FACEBOOK.getValue() + "."
						+ OAuthAppConstants.REDIRECT_URI.getValue());
		url.append(OAuthAppConstants.CLIENT_ID.getValue()).append("=")
				.append(clientId);
		url.append("&");
		url.append(OAuthAppConstants.REDIRECT_URI.getValue()).append("=")
				.append(redirectUri);
		url.append("&");
		url.append("state=").append(SocialType.FACEBOOK.getValue());
		return url.toString();
	}

	@Override
	public String getAccessTokenResponse(String code) {
		System.out.println("Getting access token");
		return null;
	}

}
