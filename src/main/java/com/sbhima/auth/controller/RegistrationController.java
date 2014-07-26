package com.sbhima.auth.controller;

import java.io.IOException;

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
import org.springframework.web.servlet.ModelAndView;

import com.sbhima.auth.controller.form.UserRegistrationForm;
import com.sbhima.auth.controller.handlers.SocialHttpHandler;
import com.sbhima.auth.controller.validator.UserRegistrationFormValidator;

@Controller
public class RegistrationController {
	private static final Logger logger = Logger
			.getLogger(RegistrationController.class);
	@Autowired
	private UserRegistrationFormValidator userRegistrationFormValidator;
	@Autowired
	private SocialHttpHandler socialHttpHandler;

	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public ModelAndView signupForm(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		ModelAndView modelAndView = new ModelAndView("signup_form");
		modelAndView.addObject("signupform", new UserRegistrationForm());
		return modelAndView;
	}

	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public ModelAndView register(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			@ModelAttribute("signupform") @Validated(value = UserRegistrationFormValidator.class) UserRegistrationForm userRegistrationForm,
			BindingResult bindingResult) {
		logger.info("New user signup process has started");
		ModelAndView modelAndView = null;
		userRegistrationFormValidator.validate(userRegistrationForm,
				bindingResult);
		if (bindingResult.hasErrors()) {
			modelAndView = new ModelAndView();
			modelAndView.addObject("fieldErrors",
					bindingResult.getFieldErrors());
			modelAndView.setViewName("signup");
		} else {
			modelAndView = new ModelAndView("redirect:/web/login");
			logger.info("New  user signup process has  completed");
		}
		return modelAndView;
	}

	@RequestMapping(value = "signupSuccess", method = RequestMethod.GET)
	public ModelAndView signupSuccess(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		logger.info("Signup Successfull");
		ModelAndView modelAndView = new ModelAndView("signup_success");
		modelAndView.addObject("email",
				httpServletRequest.getParameter("email"));
		return modelAndView;
	}

	@RequestMapping(value = "socialsignup", method = RequestMethod.GET)
	public void socialregister(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		socialHttpHandler.authorizeSocialApplication(httpServletRequest,
				httpServletResponse);
	}

	@RequestMapping(value = "socialsignupwithcode", method = RequestMethod.GET)
	public void socialsignupwithcode(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws IOException {
		socialHttpHandler.getAccessToken(httpServletRequest,
				httpServletResponse);
	}
}
