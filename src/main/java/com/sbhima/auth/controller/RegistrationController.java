package com.sbhima.auth.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.sbhima.auth.controller.commons.AjaxResponse;
import com.sbhima.auth.controller.form.UserRegistrationForm;
import com.sbhima.auth.controller.validator.UserRegistrationFormValidator;

@Controller
public class RegistrationController {
	private static final Logger logger = Logger
			.getLogger(RegistrationController.class);
	@Autowired
	private UserRegistrationFormValidator userRegistrationFormValidator;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public AjaxResponse register(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			@ModelAttribute("signupform") @Validated(value = UserRegistrationFormValidator.class) UserRegistrationForm userRegistrationForm,
			BindingResult bindingResult) {
		logger.info("New user signup process has started");
		AjaxResponse ajaxResponse = new AjaxResponse();
		userRegistrationFormValidator.validate(userRegistrationForm,
				bindingResult);
		if (bindingResult.hasErrors()) {
			ajaxResponse.setError(true);
			ajaxResponse.setData(bindingResult.getFieldErrors());
		} else {
			logger.info("New  user signup process has  completed");
		}
		return ajaxResponse;
	}

	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public ModelAndView signupForm(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		ModelAndView modelAndView = new ModelAndView("signup_form");
		modelAndView.addObject("signupform", new UserRegistrationForm());
		return modelAndView;
	}
}
