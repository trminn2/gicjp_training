package com.gic.ems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.gic.ems.common.utility.UserUtility;
import com.gic.ems.dao.UserDao;
import com.gic.ems.entity.User;
import com.gic.ems.service.M02_Service;
import com.gic.ems.web.model.M02_PasswordUpdateModel;

/**
 * The Class M02_ServiceImpl.
 *
 * @author PhuuKhinKhin Jan 27, 2019 <BR>
 *         The Class M02_ServiceImpl.
 */
@Service
public class M02_ServiceImpl implements M02_Service {

	/** The user dao. */
	private UserDao userDao;

	/** The encoder. */
	private PasswordEncoder encoder;

	/**
	 * Sets the user dao.
	 *
	 * @param userDao the new user dao
	 */
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * Sets the encoder.
	 *
	 * @param encoder the new encoder
	 */
	@Autowired
	public void setEncoder(PasswordEncoder encoder) {
		this.encoder = encoder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gic.ems.service.M02_Service#update(com.gic.ems.web.model.
	 * M02_PasswordUpdateModel)
	 */
	@Override
	public boolean update(M02_PasswordUpdateModel m02Model) {
		User user = this.userDao.findByEmail(UserUtility.getInstance().getLoginUserName()).orElse(null);
		if (null != user) {
			// TODO
			user.setPassword(this.encoder.encode(m02Model.getNewPassword()));
			userDao.save(user);
			return true;
		} else {
			return false;
		}
	}
}