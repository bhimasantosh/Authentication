package com.sbhima.auth.controller.validator;

import java.util.regex.Matcher;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sbhima.auth.controller.form.ForgotPasswordForm;
import com.sbhima.auth.controller.validator.constants.UserRegistrationFormConstants;

@Component
public class ForgotPasswordFormValidator implements Validator,
		UserRegistrationFormConstants {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return ForgotPasswordFormValidator.class
				.isAssignableFrom(ForgotPasswordFormValidator.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ForgotPasswordForm forgotPasswordForm = (ForgotPasswordForm) target;
		Matcher emailMatcher = email.matcher(forgotPasswordForm.getEmail());
		if (!(emailMatcher.find())) {
			errors.rejectValue("email", invalidEmail, "");
		}
	}

}
