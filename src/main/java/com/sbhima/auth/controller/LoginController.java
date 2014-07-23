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
import com.sbhima.auth.controller.form.UserLoginForm;
import com.sbhima.auth.controller.validator.UserLoginFormValidator;

@Controller
public class LoginController {
	private static final Logger logger = Logger
			.getLogger(LoginController.class);
	@Autowired
	private UserLoginFormValidator userLoginFormValidator;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("loginForm", new UserLoginForm());
		return modelAndView;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public AjaxResponse login(
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse,
			@ModelAttribute("loginForm") @Validated(value = UserLoginForm.class) UserLoginForm userLoginForm,
			BindingResult bindingResult) {
		logger.info("user login has started");
		AjaxResponse ajaxResponse = new AjaxResponse();
		userLoginFormValidator.validate(userLoginForm, bindingResult);
		if (bindingResult.hasErrors()) {
			ajaxResponse.setData(bindingResult.getFieldErrors());
			ajaxResponse.setError(true);
		} else {
			ajaxResponse.setData("Successfully Logged In");
		}
		return ajaxResponse;
	}
}
