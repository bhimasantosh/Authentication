package com.sbhima.auth.social.facebook.dto;

public class FacebookPost {
	private String id;
	private String message;
	private String name;
	private String created_time;
	private FacebookCompany from;
	private String description;
	private String caption;
	private FacebookLikes likes;
	private boolean liked = false;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreated_time() {
		return created_time;
	}

	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}

	public FacebookCompany getFrom() {
		return from;
	}

	public void setFrom(FacebookCompany from) {
		this.from = from;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public FacebookLikes getLikes() {
		return likes;
	}

	public void setLikes(FacebookLikes likes) {
		this.likes = likes;
	}

	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}
}
