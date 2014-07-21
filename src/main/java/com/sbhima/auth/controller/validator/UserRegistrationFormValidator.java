package com.sbhima.auth.controller.validator;

import java.util.regex.Matcher;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sbhima.auth.controller.form.UserRegistrationForm;
import com.sbhima.auth.controller.validator.constants.UserRegistrationFormConstants;

@Component
public class UserRegistrationFormValidator implements Validator,
		UserRegistrationFormConstants {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserRegistrationForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserRegistrationForm userRegistrationForm = (UserRegistrationForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailOrPhone",
				wrongEmailOrPhone);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				invalidPassword);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
				invalidPassword);
		Matcher emailMatcher = email.matcher(userRegistrationForm
				.getEmailOrPhone());
		Matcher phoneMatcher = phone.matcher(userRegistrationForm
				.getEmailOrPhone());
		if (!(emailMatcher.find() || phoneMatcher.find())) {
			errors.rejectValue("emailOrPhone", invalidEmailOrPhone, "");
		}
		if (userRegistrationForm.getPassword() != null
				&& userRegistrationForm.getConfirmPassword() != null
				&& !userRegistrationForm.getPassword().equalsIgnoreCase(
						userRegistrationForm.getConfirmPassword())) {
			errors.rejectValue("password", passwordConfirmPasswordMismatch, "");
		} else if (userRegistrationForm.getPassword().length() < passwordLength) {
			errors.rejectValue("password", invalidPasswordSize, "");
		} else {
			Matcher hasLetter = letter.matcher(userRegistrationForm
					.getPassword());
			Matcher hasNumber = digit.matcher(userRegistrationForm
					.getPassword());
			Matcher hasSpecialCharacters = special.matcher(userRegistrationForm
					.getPassword());
			if (!hasLetter.find()) {
				errors.rejectValue("password", invalidLetterPassword, "");
			}
			if (!hasNumber.find()) {
				errors.rejectValue("password", invalidDigitPassword, "");
			}
			if (!hasSpecialCharacters.find()) {
				errors.rejectValue("password", invalidSpecialCharacterPassword,
						"");
			}
		}
	}

}
