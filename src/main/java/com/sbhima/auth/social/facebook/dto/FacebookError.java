package com.sbhima.auth.social.facebook.dto;

public class FacebookError {
	
	public static int ERROR_UNKNOWN_PATH_COMPONENT = 2500;
	public static int TOKEN_ERROR = 190;
	public static int TOKEN_ERROR_1 = 100;
	public static int TOKEN_EXPIRED = 200;
	private FacebookErrorDetail error;
	
	public FacebookErrorDetail getError() {
		return error;
	}
	public void setError(FacebookErrorDetail error) {
		this.error = error;
	};
}

