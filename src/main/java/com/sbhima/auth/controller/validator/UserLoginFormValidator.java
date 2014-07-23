package com.sbhima.auth.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sbhima.auth.controller.form.UserLoginForm;
import com.sbhima.auth.controller.validator.constants.UserLoginFormConstants;

@Component
public class UserLoginFormValidator implements Validator,
		UserLoginFormConstants {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserLoginForm.class.isAssignableFrom(UserLoginForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils
				.rejectIfEmptyOrWhitespace(errors, "email", invalidEmail);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				invalidPassword);
	}
}
