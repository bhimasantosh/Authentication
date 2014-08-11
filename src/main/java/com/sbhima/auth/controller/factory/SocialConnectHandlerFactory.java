package com.sbhima.auth.controller.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbhima.auth.controller.handlers.FacebookConnectHandler;
import com.sbhima.auth.controller.service.ISocialConnectHandlerService;

@Service
public class SocialConnectHandlerFactory {
	@Autowired
	private FacebookConnectHandler facebookConnectHandler;

	public ISocialConnectHandlerService getConnectHandlerService(
			String socialType) {
		if (socialType != null && socialType.equalsIgnoreCase("facebook")) {
			return facebookConnectHandler;
		}
		return null;
	}
}
