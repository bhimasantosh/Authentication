package com.sbhima.auth.social.facebook.dto;

import java.io.Serializable;

public class FacebookEmployer implements Serializable {

	private static final long serialVersionUID = -1794444891373232387L;

	//
	private String id = null;
	private String name = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}