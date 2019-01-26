package com.gic.ems.service;

import com.gic.ems.entity.User;

import lombok.NonNull;

/**
 * The Interface M01_Service.
 *
 * @author KYIMINHAN Jan 27, 2019 <BR>
 *         The Interface M01_Service.
 */
public interface M01_Service {

	/**
	 * Find by email.
	 *
	 * @param email the email
	 * @return User
	 */
	User findByEmail(@NonNull String email);
}