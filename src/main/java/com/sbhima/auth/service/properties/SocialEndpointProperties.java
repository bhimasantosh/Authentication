package com.sbhima.auth.service.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = { "social.properties" })
public class SocialEndpointProperties {
	@Autowired
	private Environment env;

	public String getProperty(String key) {
		return env.getProperty(key);
	}
}
	