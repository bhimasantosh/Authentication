
package com.sbhima.auth.social.constants;

public enum FacebookFields {
	ID("id"), FIRST_NAME("first_name"), LAST_NAME("last_name"), NAME("name"), WORK(
			"work"), EDUCATION("education"), LOCATION("location"), PICTURE(
			"picture"), BIRTHDAY("birthday"), RELATIONSHIP_STATUS(
			"relationship_status"), EMAIL("email"), BIO("bio"), POLITICAL(
			"political"), CATEGORY("category"), COVER("cover"), COMPANY_OVERVIEW(
			"company_overview"), LIKES_COUNT("likes"), COMPANY_COMMENTS_COUNT(
			"talking_about_count"), ABOUT("about"), WEBSITE("website"), USERNAME(
			"username"), DESCRIPTION("description"), MESSAGE("message"), CREATED_TIME(
			"created_time"), FROM("from"), CAPTION("caption"), LINK("link"), LIKES(
			"likes");

	private String value;

	FacebookFields(String value) {
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static String getFieldsForMatches() {
		return FacebookFields.ID.getValue() + ","
				+ FacebookFields.NAME.getValue() + ","
				+ FacebookFields.FIRST_NAME.getValue() + ","
				+ FacebookFields.LAST_NAME.getValue() + ","
				+ FacebookFields.WORK.getValue() + ","
				+ FacebookFields.EDUCATION.getValue() + ","
				+ FacebookFields.LOCATION.getValue() + ","
				+ FacebookFields.PICTURE.getValue() + ","
				+ FacebookFields.BIRTHDAY.getValue() + ","
				+ FacebookFields.RELATIONSHIP_STATUS.getValue();
	}

	public static String getFieldsForCompanyMatches() {
		return FacebookFields.ID.getValue() + ","
				+ FacebookFields.NAME.getValue() + ","
				+ FacebookFields.COMPANY_OVERVIEW.getValue() + ","
				+ FacebookFields.CATEGORY.getValue() + ","
				+ FacebookFields.PICTURE.getValue() + ","
				+ FacebookFields.ABOUT.getValue() + ","
				+ FacebookFields.WEBSITE.getValue() + ","
				+ FacebookFields.USERNAME.getValue() + ","
				+ FacebookFields.LINK.getValue();
	}

	public static String getFieldsForCompanyPosts() {
		return FacebookFields.ID.getValue() + ","
				+ FacebookFields.NAME.getValue() + ","
				+ FacebookFields.MESSAGE.getValue() + ","
				+ FacebookFields.CREATED_TIME.getValue() + ","
				+ FacebookFields.CAPTION.getValue() + ","
				+ FacebookFields.ID.getValue() + ","
				+ FacebookFields.CAPTION.getValue() + ","
				+ FacebookFields.FROM.getValue() + ","
				+ FacebookFields.LIKES.getValue();
	}

	public static String getFieldsForCompanyProfile() {
		return FacebookFields.ID.getValue() + ","
				+ FacebookFields.NAME.getValue() + ","
				+ FacebookFields.COMPANY_OVERVIEW.getValue() + ","
				+ FacebookFields.LIKES_COUNT.getValue() + ","
				+ FacebookFields.COMPANY_COMMENTS_COUNT.getValue() + ","
				+ FacebookFields.PICTURE.getValue() + ","
				+ FacebookFields.LOCATION.getValue() + ","
				+ FacebookFields.ABOUT.getValue() + ","
				+ FacebookFields.WEBSITE.getValue() + ","
				+ FacebookFields.USERNAME.getValue() + ","
				+ FacebookFields.LINK.getValue();
	}

	public static String getFieldsForConnections() {
		return FacebookFields.ID.getValue() + ","
				+ FacebookFields.FIRST_NAME.getValue() + ","
				+ FacebookFields.LAST_NAME.getValue() + ","
				+ FacebookFields.WORK.getValue() + ","
				+ FacebookFields.LOCATION.getValue() + ","
				+ FacebookFields.EMAIL.getValue();
	}

	public static String getFieldsForFacebookProfile() {
		return FacebookFields.ID.getValue() + ","
				+ FacebookFields.NAME.getValue() + ","
				+ FacebookFields.FIRST_NAME.getValue() + ","
				+ FacebookFields.LAST_NAME.getValue() + ","
				+ FacebookFields.BIRTHDAY.getValue() + ","
				+ FacebookFields.PICTURE.getValue() + ","
				+ FacebookFields.EMAIL.getValue();
	}

	public static String getFieldsForMutualFriends() {
		return FacebookFields.ID.getValue() + ","
				+ FacebookFields.NAME.getValue() + ","
				+ FacebookFields.FIRST_NAME.getValue() + ","
				+ FacebookFields.LAST_NAME.getValue() + ","
				+ FacebookFields.PICTURE.getValue();
	}
}
