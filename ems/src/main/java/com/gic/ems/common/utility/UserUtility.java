package com.gic.ems.common.utility;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.gic.ems.common.constant.Constant;

/**
 * The Class UserUtility.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 *         The Class UserUtility.
 */
public class UserUtility {

	/**
	 * Gets the login user.
	 *
	 * @return the login user
	 */
	public static User getLoginUser() {
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
	public static String getLoginUserName() {
		return (null != getLoginUser()) ? getLoginUser().getUsername() : Constant.SYSTEM;
	}

	/**
	 * Gets the login use role.
	 *
	 * @return the login use role
	 */
	public static String getLoginUseRole() {
		return null;
	}
}