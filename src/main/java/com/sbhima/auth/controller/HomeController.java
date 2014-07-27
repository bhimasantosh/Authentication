package com.sbhima.auth.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sbhima.auth.persistence.entity.User;

@Controller
public class HomeController {
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		ModelAndView modelAndView = new ModelAndView("home");
		User user = (User) httpServletRequest.getSession().getAttribute("USER");
		modelAndView.addObject("user", user);
		return modelAndView;
	}
}
