package com.sbhima.auth.social.facebook.dto;

public enum FacebookObjectType {
	USER("user"), COMPANY("page");

	private FacebookObjectType(String type) {
		this.type = type;
	}

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
