package com.gic.ems.service;

import com.gic.ems.entity.User;

public interface M01_Service {
	User findByEmail(String email);

	// TODO delete this function after developing
	void save(User user);
}