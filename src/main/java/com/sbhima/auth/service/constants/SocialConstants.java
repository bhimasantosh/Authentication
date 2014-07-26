package com.sbhima.auth.service.constants;

public enum SocialConstants {
	FACEBOOK("facebook"), TWITTER("twitter");
	private String value;

	SocialConstants(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
