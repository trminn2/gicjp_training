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

	/** The user utility. */
	private volatile static UserUtility userUtility;

	/**
	 * Instantiates a new user utility.
	 */
	private UserUtility() {
		super();
	}

	/**
	 * Gets the single instance of UserUtility.
	 *
	 * @return single instance of UserUtility
	 */
	public static UserUtility getInstance() {
		if (null == userUtility) {
			synchronized (UserUtility.class) {
				userUtility = new UserUtility();
			}
		}
		return userUtility;
	}

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
		return (null != getLoginUser()) ? getLoginUser().getUsername() : Constant.SYSTEM;
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