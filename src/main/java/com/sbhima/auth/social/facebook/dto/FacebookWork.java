package com.sbhima.auth.social.facebook.dto;

import java.io.Serializable;

public class FacebookWork implements Serializable {

	private static final long serialVersionUID = -2504415345462669884L;

	//
	private FacebookEmployer employer = null;
	private FacebookLocation location = null;
	private FacebookPosition position = null;
	private String description = null;
	private String start_date = null;
	private String end_date = null;

	public FacebookEmployer getEmployer() {
		return employer;
	}

	public void setEmployer(FacebookEmployer employer) {
		this.employer = employer;
	}

	public FacebookLocation getLocation() {
		return location;
	}

	public void setLocation(FacebookLocation location) {
		this.location = location;
	}

	public FacebookPosition getPosition() {
		return position;
	}

	public void setPosition(FacebookPosition position) {
		this.position = position;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String startDate) {
		this.start_date = startDate;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String endDate) {
		this.end_date = endDate;
	}

}