package com.sbhima.auth.social.facebook.dto;

import java.io.Serializable;

public class FacebookLocation implements Serializable{
	private static final long serialVersionUID = 7851804594087676485L;
	
	//
	private String name = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
