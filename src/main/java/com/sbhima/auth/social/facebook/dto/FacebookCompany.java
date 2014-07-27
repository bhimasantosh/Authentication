package com.sbhima.auth.social.facebook.dto;

public class FacebookCompany {
	private String name;
	private String category;
	private String company_overview;
	private FacebookCover cover;
	private String id;
	private int likes;
	private int talking_about_count;
	private FacebookPicture picture;
	private FacebookCompanyLocation location;
	private String about;
	private String website;
	private String username;
	private String link;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCompany_overview() {
		return company_overview;
	}

	public void setCompany_overview(String company_overview) {
		this.company_overview = company_overview;
	}

	public FacebookCover getCover() {
		return cover;
	}

	public void setCover(FacebookCover cover) {
		this.cover = cover;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getTalking_about_count() {
		return talking_about_count;
	}

	public void setTalking_about_count(int talking_about_count) {
		this.talking_about_count = talking_about_count;
	}

	public FacebookPicture getPicture() {
		return picture;
	}

	public void setPicture(FacebookPicture picture) {
		this.picture = picture;
	}

	public FacebookCompanyLocation getLocation() {
		return location;
	}

	public void setLocation(FacebookCompanyLocation location) {
		this.location = location;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		if(website!=null && website.length()>0)
			this.website = website.split("\n")[0]; 
		else
			this.website = website;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPicture_square() {
		StringBuilder image = new StringBuilder();
		image.append("https://graph.facebook.com/");
		image.append(this.getId());
		image.append("/picture?type=square");
		return image.toString();
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
