package com.sbhima.auth.social.facebook.dto;

import java.util.ArrayList;
import java.util.List;

public class FacebookLikes {
	private List<FacebookUser> data = new ArrayList<FacebookUser>();

	public List<FacebookUser> getData() {
		return data;
	}

	public void setData(List<FacebookUser> data) {
		this.data = data;
	}
}
