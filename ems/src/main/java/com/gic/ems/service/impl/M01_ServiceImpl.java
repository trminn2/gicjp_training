package com.gic.ems.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gic.ems.common.type.DeleteFlag;
import com.gic.ems.dao.UserDao;
import com.gic.ems.entity.User;
import com.gic.ems.service.M01_Service;

import lombok.NonNull;

/**
 * The Class M01_ServiceImpl.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Jan 26, 2019 </BR>
 *        ems system </BR>
 *        com.gic.ems.service.impl </BR>
 *        M01_ServiceImpl.java </BR>
 */
@Service("m01_ServiceImpl")
public class M01_ServiceImpl implements M01_Service, UserDetailsService {

	/** The user dao. */
	private UserDao userDao;

	/**
	 * Sets the user dao.
	 *
	 * @param userDao the new user dao
	 */
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.gic.ems.service.M01_Service#findByEmail(java.lang.String)
	 */
	@Override
	public User findByEmail(String email) {
		return this.userDao.findByEmailAndDeleteFlag(email, DeleteFlag.ACTIVE).orElse(null);
	}

	/**
	 * Gets the autority.
	 *
	 * @param user the user
	 * @return the autority
	 */
	private Collection<? extends GrantedAuthority> getAutority(@NonNull User user) {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
		return authorities;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(@NonNull String email) throws UsernameNotFoundException {
		User user = this.findByEmail(email);
		if (null == user) {
			throw new UsernameNotFoundException("User not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), true, true,
				true, true, this.getAutority(user));
	}
}