package com.sbhima.auth.social.facebook.dto;


public class FacebookResults {
	private String id;
	private FacebookUser facebookUser;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public FacebookUser getFacebookUser() {
		return facebookUser;
	}

	public void setFacebookUser(FacebookUser facebookUser) {
		this.facebookUser = facebookUser;
	}

}
