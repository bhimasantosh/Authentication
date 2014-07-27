package com.sbhima.auth.controller.handlers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.sbhima.auth.persistence.entity.User;

@Service
public class SessionHttpHandler {
	public void updateSessionWithUser(HttpServletRequest httpServletRequest,
			User user) {
		httpServletRequest.getSession().setAttribute("USER", user);
	}
}
