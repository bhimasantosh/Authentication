package com.sbhima.auth.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sbhima.auth.controller.handlers.ConnectHandler;

@Controller
public class ConnectController {
	@Autowired
	private ConnectHandler connectHandler;

	@RequestMapping(value = "connect", method = RequestMethod.GET)
	public ModelAndView connect(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		ModelAndView modelAndView = new ModelAndView("connect");
		return modelAndView;
	}

	@RequestMapping(value = "importFriends", method = RequestMethod.GET)
	public void importFriends(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		connectHandler.importFriends(httpServletRequest, httpServletResponse);
	}
}
