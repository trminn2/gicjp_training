package com.gic.ems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gic.ems.common.type.DeleteFlag;
import com.gic.ems.dao.UserDao;
import com.gic.ems.entity.User;
import com.gic.ems.service.M01_Service;

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
@Service
public class M01_ServiceImpl implements M01_Service {

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

}