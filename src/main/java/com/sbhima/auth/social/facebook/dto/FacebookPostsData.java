package com.sbhima.auth.social.facebook.dto;

import java.util.ArrayList;
import java.util.List;

public class FacebookPostsData {
	private List<FacebookPost> data = new ArrayList<FacebookPost>();

	public List<FacebookPost> getData() {
		return data;
	}

	public void setData(List<FacebookPost> data) {
		this.data = data;
	}
}
