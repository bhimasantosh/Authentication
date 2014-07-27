package com.sbhima.auth.social.facebook.dto;

public class FacebookEducation {
	private FacebookSchool school;
	private FacebookEducationYear year;
	private String type;

	public FacebookSchool getFacebookSchool() {
		return school;
	}

	public void setFacebookSchool(FacebookSchool facebookSchool) {
		this.school = facebookSchool;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public FacebookEducationYear getFacebookEducationYear() {
		return year;
	}

	public void setFacebookEducationYear(
			FacebookEducationYear facebookEducationYear) {
		this.year = facebookEducationYear;
	}
}
