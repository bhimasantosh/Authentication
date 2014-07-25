package com.sbhima.auth.service.constants;

public enum OAuthAppConstants {
	CLIENT_ID("client_id"), CLIENT_SECRET("client_secret"), REDIRECT_URI(
			"redirect_uri");
	private String value;

	private OAuthAppConstants(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
