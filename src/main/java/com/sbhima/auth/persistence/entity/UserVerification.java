package com.sbhima.auth.persistence.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_verification")
public class UserVerification extends CommonEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3549514255193810103L;
	@OneToOne(targetEntity = User.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "id")
	@Id
	private User user;
	@Column(name = "verification_token")
	private String verificationToken;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getVerificationToken() {
		return verificationToken;
	}

	public void setVerificationToken(String verificationToken) {
		this.verificationToken = verificationToken;
	}
}
