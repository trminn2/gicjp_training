package com.gic.ems.common.utility;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
public class UserUtility {

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

	public String getLoginUserName() {
		return getLoginUser().getUsername();
	}
}