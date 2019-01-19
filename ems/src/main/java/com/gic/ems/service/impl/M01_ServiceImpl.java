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
import org.springframework.transaction.annotation.Transactional;

import com.gic.ems.dao.UserDao;
import com.gic.ems.entity.User;
import com.gic.ems.service.M01_Service;

@Service("m01_ServiceImpl")
public class M01_ServiceImpl implements M01_Service, UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = this.findByEmail(email);
		if (null == user) {
			throw new UsernameNotFoundException("User not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), true, true,
				true, true, getAutority(user));
	}

	private Collection<? extends GrantedAuthority> getAutority(User user) {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
		return authorities;
	}

	@Override
	public User findByEmail(String email) {
		return this.userDao.findByEmail(email).orElse(null);
	}

	// TODO delete this function after developing
	@Transactional
	@Override
	public void save(User user) {
		this.userDao.save(user);
	}
}