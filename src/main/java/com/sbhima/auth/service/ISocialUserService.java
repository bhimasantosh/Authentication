package com.sbhima.auth.service;

import java.io.Serializable;

import com.sbhima.auth.persistence.entity.CommonEntity;

public interface ISocialUserService {
	/**
	 * Return the social type of the implementing class
	 * 
	 * @return
	 */
	int getSocialType();

	/**
	 * Return the email address for the given social user
	 * 
	 * @param serializable
	 * @return
	 */
	String getSocialEmail(Serializable serializable);

	/**
	 * Populate the persistent user object for the given social persistent user object
	 * @param commonEntity
	 * @throws Exception
	 */
	void populateUserEntity(CommonEntity commonEntity) throws Exception;
}
