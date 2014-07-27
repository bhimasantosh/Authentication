package com.sbhima.auth.service;

import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbhima.auth.controller.form.UserRegistrationForm;
import com.sbhima.auth.persistence.entity.CommonEntity;
import com.sbhima.auth.persistence.entity.User;
import com.sbhima.auth.persistence.service.EntityService;
import com.sbhima.auth.persistence.service.UserService;
import com.sbhima.auth.service.factory.SocialServiceFactory;
import com.sbhima.auth.service.factory.SocialUserServiceFactory;

@Service
public class UserSignupService {
	@Autowired
	private SocialServiceFactory socialServiceFactory;
	@Autowired
	private SocialUserServiceFactory socialUserServiceFactory;
	@Autowired
	private UserService userService;
	@Autowired
	private EntityService entityService;

	public void saveUserByForm(UserRegistrationForm userRegistrationForm)
			throws Exception {
		User user = new User();
		user.setEmail(userRegistrationForm.getEmail());
		user.setFirstName(userRegistrationForm.getFirstName());
		user.setLastName(userRegistrationForm.getLastName());
		byte[] passwordBytes = userRegistrationForm.getPassword().getBytes(
				"UTF-8");
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		user.setPassword(new String(messageDigest.digest(passwordBytes)));
		userService.saveOrUpdate(user);
	}

	public void populateIfUserExists(CommonEntity commonEntity,
			String socialType) throws Exception {
		ISocialUserService socialUserService = socialUserServiceFactory
				.getSocialUserService(socialType);
		socialUserService.populateUserEntity(commonEntity);
	}

	public User saveAndLoadUser(CommonEntity entity) throws Exception {
		return entityService.saveOrUpdateSocialUser(entity);
	}

}
