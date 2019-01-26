package com.gic.ems.common.utility;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

/**
 * The Class UserUtility.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 *         The Class UserUtility.
 */
@Component
public class UserUtility {

	/**
	 * Gets the login user.
	 *
	 * @return the login user
	 */
	public User getLoginUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User userDetail = null;
		if (null != auth) {
			Object principal = auth.getPrincipal();
			if (principal instanceof User)
				userDetail = (User) principal;
		}
		return userDetail;
	}

	/**
	 * Gets the login user name.
	 *
	 * @return the login user name
	 */
	public String getLoginUserName() {
		return getLoginUser().getUsername();
	}

	/**
	 * Gets the login use role.
	 *
	 * @return the login use role
	 */
	public String getLoginUseRole() {
		return null;
	}
}