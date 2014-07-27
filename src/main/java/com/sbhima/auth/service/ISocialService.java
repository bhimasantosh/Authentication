package com.sbhima.auth.service;

import java.io.IOException;
import java.io.Serializable;

import org.apache.commons.httpclient.HttpException;

import com.sbhima.auth.persistence.entity.CommonEntity;

public interface ISocialService {
	/**
	 * Return the complete url populated with client id, redirect uri and state.
	 * This url can be used to redirect the client to authorize the social
	 * application
	 * 
	 * @return
	 */
	String getAuthorizationRedirectURL();

	/**
	 * Once the user authorises the application the application is redirected to
	 * an endpoint with code populated. This code can be used along with client
	 * id,client secret to obtain access token.
	 * 
	 * @return
	 * @throws IOException
	 * @throws HttpException
	 */
	String getAccessTokenResponse(String code) throws HttpException,
			IOException;

	/**
	 * Return user information populated with complete user information given
	 * user access token
	 * 
	 * @param accessToken
	 * @return
	 * @throws Exception
	 */
	Serializable getUserDetails(String accessToken) throws Exception;

	/**
	 * Convert the socialuser into persistent user entity
	 * 
	 * @param socialUser
	 * @param accessToken
	 * @return
	 */
	CommonEntity getUserFromSocialUser(Serializable socialUser,
			String accessToken);
}
