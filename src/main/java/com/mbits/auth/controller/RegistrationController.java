package com.mbits.auth.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mbits.auth.controller.commons.AjaxResponse;
import com.mbits.auth.controller.form.UserRegistrationForm;
import com.mbits.auth.controller.validator.UserRegistrationFormValidator;

@Controller
public class RegistrationController {
	private static final Logger logger = Logger
			.getLogger(RegistrationController.class);
	@Autowired
	private UserRegistrationFormValidator userRegistrationFormValidator;

	@ResponseBody
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public AjaxResponse register(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			@ModelAttribute("newuser") @Validated(value = UserRegistrationFormValidator.class) UserRegistrationForm userRegistrationForm,
			BindingResult bindingResult) {
		logger.info("New user signup process has started");
		AjaxResponse ajaxResponse = new AjaxResponse();
		userRegistrationFormValidator.validate(userRegistrationForm,
				bindingResult);
		if (bindingResult.hasErrors()) {
			ajaxResponse.setError(true);
		} else {
			logger.info("New  user signup process has  completed");
		}
		return ajaxResponse;
	}
}
