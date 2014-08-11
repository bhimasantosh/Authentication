package com.sbhima.auth.controller.handlers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbhima.auth.controller.factory.SocialConnectHandlerFactory;
import com.sbhima.auth.controller.service.ISocialConnectHandlerService;
import com.sbhima.auth.persistence.entity.User;

@Service
public class ConnectHandler {
	@Autowired
	private SocialConnectHandlerFactory socialConnectHandlerFactory;

	public void setContext(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) {
		String socialType = httpServletRequest.getParameter("socialType");

	}

	public void importFriends(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws Exception {
		String socialType = httpServletRequest.getParameter("socialType");
		User user = (User) httpServletRequest.getSession().getAttribute("USER");
		ISocialConnectHandlerService socialConnectHandlerService = socialConnectHandlerFactory
				.getConnectHandlerService(socialType);
		socialConnectHandlerService.getSocialFriends(user.getId());
	}
}
