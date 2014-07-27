package com.sbhima.auth.service.constants;

public enum AuthorizationStatus {
	NOT_AUTHORIZED(0), EMAIL_AUTHORIZED(1), PHONE_AUTHORIZED(2);
	private int value;

	AuthorizationStatus(int value) {
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
