package com.sbhima.auth.service.impl;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbhima.auth.persistence.entity.CommonEntity;
import com.sbhima.auth.persistence.entity.FacebookUserEntity;
import com.sbhima.auth.persistence.entity.User;
import com.sbhima.auth.service.ISocialService;
import com.sbhima.auth.service.constants.AuthorizationStatus;
import com.sbhima.auth.service.constants.FacebookOAuthAppConstants;
import com.sbhima.auth.service.constants.SocialConstants;
import com.sbhima.auth.service.constants.SocialType;
import com.sbhima.auth.service.properties.FacebookApplicationProperties;
import com.sbhima.auth.service.properties.SocialEndpointProperties;
import com.sbhima.auth.social.constants.FacebookFields;
import com.sbhima.auth.social.dto.SocialProfile;
import com.sbhima.auth.social.facebook.dto.FacebookUser;
import com.sbhima.auth.social.facebook.dto.FacebookUserJsonData;

@Service
public class FacebookSocialService implements ISocialService {
	@Autowired
	private FacebookApplicationProperties facebookApplicationProperties;
	@Autowired
	private SocialEndpointProperties socialEndpointProperties;

	@Override
	public String getAuthorizationRedirectURL() {
		StringBuilder url = new StringBuilder();
		url.append(socialEndpointProperties
				.getProperty(SocialConstants.FACEBOOK.getValue() + ".endpoint"));
		url.append("?");
		String clientId = facebookApplicationProperties
				.getProperty(SocialConstants.FACEBOOK.getValue() + "."
						+ FacebookOAuthAppConstants.CLIENT_ID.getValue());
		String redirectUri = facebookApplicationProperties
				.getProperty(SocialConstants.FACEBOOK.getValue() + "."
						+ FacebookOAuthAppConstants.REDIRECT_URI.getValue());
		String scope = facebookApplicationProperties
				.getProperty(SocialConstants.FACEBOOK.getValue() + "."
						+ FacebookOAuthAppConstants.SCOPE.getValue());
		url.append(FacebookOAuthAppConstants.CLIENT_ID.getValue()).append("=")
				.append(clientId);
		url.append("&");

		url.append(FacebookOAuthAppConstants.REDIRECT_URI.getValue())
				.append("=").append(redirectUri);
		url.append("&");

		url.append(FacebookOAuthAppConstants.SCOPE.getValue()).append("=")
				.append(scope);
		url.append("&");

		url.append("state=").append(SocialConstants.FACEBOOK.getValue());
		return url.toString();
	}

	@Override
	public String getAccessTokenResponse(String code) throws HttpException,
			IOException {

		HttpClient httpClient = new HttpClient();
		String endpoint = socialEndpointProperties
				.getProperty(SocialConstants.FACEBOOK.getValue()
						+ ".token_endpoint");
		GetMethod getMethod = new GetMethod(endpoint);
		String clientId = facebookApplicationProperties
				.getProperty(SocialConstants.FACEBOOK.getValue() + "."
						+ FacebookOAuthAppConstants.CLIENT_ID.getValue());
		String clientSecret = facebookApplicationProperties
				.getProperty(SocialConstants.FACEBOOK.getValue() + "."
						+ FacebookOAuthAppConstants.CLIENT_SECRET.getValue());
		String redirectUri = facebookApplicationProperties
				.getProperty(SocialConstants.FACEBOOK.getValue() + "."
						+ FacebookOAuthAppConstants.REDIRECT_URI.getValue());
		NameValuePair clientidNameValuePair = new NameValuePair(
				FacebookOAuthAppConstants.CLIENT_ID.getValue(), clientId);
		NameValuePair clientsecretNameValuePair = new NameValuePair(
				FacebookOAuthAppConstants.CLIENT_SECRET.getValue(),
				clientSecret);
		NameValuePair redirectUriNameValuePair = new NameValuePair(
				FacebookOAuthAppConstants.REDIRECT_URI.getValue(), redirectUri);
		NameValuePair codeNameValuePair = new NameValuePair(
				FacebookOAuthAppConstants.CODE.getValue(), code);
		NameValuePair[] nameValuePairs = new NameValuePair[] {
				clientidNameValuePair, clientsecretNameValuePair,
				redirectUriNameValuePair, codeNameValuePair };
		getMethod.setQueryString(nameValuePairs);
		httpClient.executeMethod(getMethod);
		String response = getMethod.getResponseBodyAsString();
		String accessToken = StringUtils.removeStart(
				response.split("&expires")[0], "access_token=");
		return accessToken;
	}

	@Override
	public Serializable getUserDetails(String accessToken) throws Exception {
		HttpClient httpClient = new HttpClient();
		String endpoint = socialEndpointProperties
				.getProperty(SocialConstants.FACEBOOK.getValue()
						+ ".graph_endpoint");
		GetMethod getMethod = new GetMethod(endpoint + "/me");
		NameValuePair fields = new NameValuePair("fields",
				FacebookFields.getFieldsForFacebookProfile());
		NameValuePair token = new NameValuePair("access_token", accessToken);
		NameValuePair[] nameValuePairs = new NameValuePair[] { fields, token };
		getMethod.setQueryString(nameValuePairs);
		httpClient.executeMethod(getMethod);
		String response = getMethod.getResponseBodyAsString();
		ObjectMapper objectMapper = new ObjectMapper();
		FacebookUser facebookUser = objectMapper.readValue(response,
				FacebookUser.class);
		return facebookUser;
	}

	public CommonEntity getUserFromSocialUser(Serializable socialUser,
			String accessToken) {
		FacebookUser facebookUser = (FacebookUser) socialUser;
		User user = new User();
		user.setFirstName(facebookUser.getFirst_name());
		user.setLastName(facebookUser.getLast_name());
		user.setPassword("");
		user.setEmail(facebookUser.getEmail());
		user.setSocialType(SocialType.FACEBOOK.getValue());
		user.setStatus(AuthorizationStatus.EMAIL_AUTHORIZED.getValue());

		FacebookUserEntity facebookUserEntity = new FacebookUserEntity();
		facebookUserEntity.setAccessToken(accessToken);
		facebookUserEntity.setUser(user);
		return facebookUserEntity;
	}

	@Override
	public List<SocialProfile> getUserSocialConnections(String accessToken)
			throws Exception {
		HttpClient httpClient = new HttpClient();
		String endpoint = socialEndpointProperties
				.getProperty(SocialConstants.FACEBOOK.getValue()
						+ ".graph_endpoint");
		GetMethod getMethod = new GetMethod(endpoint + "/me/friends");
		NameValuePair fields = new NameValuePair("fields",
				FacebookFields.getFieldsForConnections());
		NameValuePair token = new NameValuePair("access_token", accessToken);
		NameValuePair[] nameValuePairs = new NameValuePair[] { fields, token };
		getMethod.setQueryString(nameValuePairs);
		httpClient.executeMethod(getMethod);
		String response = getMethod.getResponseBodyAsString();
		ObjectMapper objectMapper = new ObjectMapper();
		FacebookUserJsonData facebookUserJsonData = objectMapper.readValue(
				response, FacebookUserJsonData.class);
		List<SocialProfile> socialProfiles = new ArrayList<SocialProfile>();
		for (FacebookUser facebookUser : facebookUserJsonData.getData()) {
			SocialProfile socialProfile = new SocialProfile();
			socialProfile.setFirstName(facebookUser.getFirst_name());
			socialProfile.setLastName(facebookUser.getLast_name());
			socialProfile.setImageUrl(facebookUser.getPicture().getData()
					.getUrl());
			socialProfiles.add(socialProfile);
		}
		return socialProfiles;
	}

}
