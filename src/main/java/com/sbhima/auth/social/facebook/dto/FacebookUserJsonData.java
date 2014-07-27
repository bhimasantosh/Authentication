package com.sbhima.auth.social.facebook.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class FacebookUserJsonData implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<FacebookUser> data = new ArrayList<FacebookUser>();

	public List<FacebookUser> getData() {
		return data;
	}

	public void setData(List<FacebookUser> data) {
		this.data = data;
	}

}
