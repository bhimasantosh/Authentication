package com.sbhima.auth.service;

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
	 */
	String getAccessTokenResponse(String code);
}
