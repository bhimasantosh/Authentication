package com.sbhima.auth.service.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Configuration
@PropertySource(value = { "facebook.properties" })
@Service
public class FacebookApplicationProperties {
	@Autowired
	private Environment env;

	public String getProperty(String key) {
		return env.getProperty(key);
	}
}
