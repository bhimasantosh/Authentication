package com.sbhima.auth.controller.validator.constants;

import java.util.regex.Pattern;

public interface UserRegistrationFormConstants {
	public static final String wrongEmailOrPhone = "wrong.emailorphone";
	public static final String invalidEmail = "invalid.email";
	public static final String invalidPassword = "invalid.password";
	public static final String passwordConfirmPasswordMismatch = "mismatch.password";
	public static final String invalidPasswordSize = "length.password";
	public static final String invalidLetterPassword = "invalid.letter.password";
	public static final String invalidDigitPassword = "invalid.digit.password";
	public static final String invalidSpecialCharacterPassword = "invalid.special.password";
	public static final Pattern letter = Pattern.compile("[a-zA-z]");
	public static final Pattern digit = Pattern.compile("[0-9]");
	public static final Pattern special = Pattern
			.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
	public static final Pattern email = Pattern
			.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	public static final Pattern phone = Pattern
			.compile("(\\d-)?(\\d{3}-)?\\d{3}-\\d{4}");
	public static final int passwordLength = 8;
}
