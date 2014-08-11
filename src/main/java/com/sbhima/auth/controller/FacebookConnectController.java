package com.sbhima.auth.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FacebookConnectController {

	@RequestMapping(value = "facebook_connect", method = RequestMethod.GET)
	public ModelAndView facebookConnect(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		ModelAndView modelAndView = new ModelAndView("facebook_connect");
		return modelAndView;
	}

	public void importFriends(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		
	}
}
