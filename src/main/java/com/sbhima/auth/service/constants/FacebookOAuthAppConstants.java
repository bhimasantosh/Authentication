package com.sbhima.auth.service.constants;

public enum FacebookOAuthAppConstants {
	CLIENT_ID("client_id"), CLIENT_SECRET("client_secret"), REDIRECT_URI(
			"redirect_uri"), SCOPE("scope"), CODE("code");
	private String value;

	private FacebookOAuthAppConstants(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
