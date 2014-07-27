package com.sbhima.auth.social.facebook.dto;

import java.util.ArrayList;
import java.util.List;

public class FacebookCompanyJsonData {
	private List<FacebookCompany> data = new ArrayList<FacebookCompany>();

	public List<FacebookCompany> getData() {
		return data;
	}

	public void setData(List<FacebookCompany> data) {
		this.data = data;
	}

}
