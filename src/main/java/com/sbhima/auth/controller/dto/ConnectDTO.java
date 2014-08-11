package com.sbhima.auth.controller.dto;

public class ConnectDTO {
	private String socialType;
	private int count;

	public String getSocialType() {
		return socialType;
	}

	public void setSocialType(String socialType) {
		this.socialType = socialType;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
