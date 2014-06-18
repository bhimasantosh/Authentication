package com.mbits.auth.controller.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegistrationForm {
	@NotNull
	@Size(min = 3, max = 20)
	private String firstName;
	@NotNull
	@Size(min = 1, max = 15)
	private String lastName;
	private String emailOrPhone;
	private String password;
	private String confirmPassword;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailOrPhone() {
		return emailOrPhone;
	}

	public void setEmailOrPhone(String emailOrPhone) {
		this.emailOrPhone = emailOrPhone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
