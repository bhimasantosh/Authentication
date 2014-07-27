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
import org.springframework.web.servlet.ModelAndView;

import com.sbhima.auth.controller.form.ForgotPasswordForm;
import com.sbhima.auth.controller.form.UserLoginForm;
import com.sbhima.auth.controller.validator.ForgotPasswordFormValidator;
import com.sbhima.auth.controller.validator.UserLoginFormValidator;

@Controller
public class LoginController {
	private static final Logger logger = Logger
			.getLogger(LoginController.class);
	@Autowired
	private UserLoginFormValidator userLoginFormValidator;
	@Autowired
	private ForgotPasswordFormValidator forgotPasswordFormValidator;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		ModelAndView modelAndView = new ModelAndView();
		if (httpServletRequest.getSession().getAttribute("USER") == null) {
			modelAndView.setViewName("login");
			modelAndView.addObject("loginForm", new UserLoginForm());
		} else {
			modelAndView.setViewName("redirect:/web/home");
		}
		return modelAndView;
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			@ModelAttribute("loginForm") @Validated(value = UserLoginForm.class) UserLoginForm userLoginForm,
			BindingResult bindingResult) {
		logger.info("user login has started");
		ModelAndView modelAndView = new ModelAndView();
		userLoginFormValidator.validate(userLoginForm, bindingResult);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("fieldErrors",
					bindingResult.getFieldErrors());
			modelAndView.setViewName("login");
		} else {
			modelAndView.setViewName("home");
		}
		return modelAndView;
	}

	@RequestMapping(value = "forgotPassword", method = RequestMethod.GET)
	public ModelAndView forgotPassword(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		logger.info("forgot password");
		ModelAndView modelAndView = new ModelAndView("forgot_password");
		modelAndView.addObject("forgotPasswordform", new ForgotPasswordForm());
		return modelAndView;
	}

	@RequestMapping(value = "forgotPassword", method = RequestMethod.POST)
	public ModelAndView forgotPassword(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			@ModelAttribute("forgotPasswordform") @Validated(value = ForgotPasswordForm.class) ForgotPasswordForm forgotPasswordForm,
			BindingResult bindingResult) {
		logger.info("forgot password save");
		ModelAndView modelAndView = new ModelAndView();
		forgotPasswordFormValidator.validate(forgotPasswordForm, bindingResult);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("fieldErrors",
					bindingResult.getFieldErrors());
			modelAndView.setViewName("forgot_password");
		} else {
			modelAndView.addObject("email", forgotPasswordForm.getEmail());
			modelAndView.setViewName("forgot_password_success");
		}
		return modelAndView;
	}
}
