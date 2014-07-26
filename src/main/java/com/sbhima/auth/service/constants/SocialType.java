package com.sbhima.auth.service.constants;

public enum SocialType {
	FACEBOOK(1), TWITTER(2), SELF(100);
	private int value;

	SocialType(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
