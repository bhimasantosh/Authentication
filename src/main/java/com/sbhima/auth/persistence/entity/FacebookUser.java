package com.sbhima.auth.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "facebook_users")
public class FacebookUser extends DateEntity {
	@OneToOne(targetEntity = User.class)
	@JoinColumn(name = "id")
	@Id
	private User user;
	@Column(name = "access_token")
	private String accessToken;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}
