package com.gic.ems.common.utility;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import com.gic.ems.common.constant.Constant;

/**
 * The Class UserUtility.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Jan 27, 2019 </BR>
 *        ems system </BR>
 *        com.gic.ems.common.utility </BR>
 *        UserUtility.java </BR>
 */
public final class UserUtility {

	/** The user utility. */
	private volatile static UserUtility userUtility;

	/**
	 * Gets the single instance of UserUtility.
	 *
	 * @return single instance of UserUtility
	 */
	public static UserUtility getInstance() {
		if (null == UserUtility.userUtility) {
			synchronized (UserUtility.class) {
				UserUtility.userUtility = new UserUtility();
			}
		}
		return UserUtility.userUtility;
	}

	/**
	 * Instantiates a new user utility.
	 */
	private UserUtility() {
		super();
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
			if (principal instanceof User) {
				userDetail = (User) principal;
			}
		}
		return userDetail;
	}

	/**
	 * Gets the login user name.
	 *
	 * @return the login user name
	 */
	public String getLoginUserName() {
		return (null != this.getLoginUser()) ? this.getLoginUser().getUsername() : Constant.SYSTEM;
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