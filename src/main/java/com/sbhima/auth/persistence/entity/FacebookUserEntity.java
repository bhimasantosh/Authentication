package com.sbhima.auth.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "facebook_users")
public class FacebookUserEntity extends CommonEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8790556290786341154L;
	@OneToOne
	@JoinColumn(name = "id")
	@EmbeddedId
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
