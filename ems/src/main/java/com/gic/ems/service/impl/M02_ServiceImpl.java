package com.gic.ems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gic.ems.common.type.DeleteFlag;
import com.gic.ems.common.utility.UserUtility;
import com.gic.ems.dao.UserDao;
import com.gic.ems.entity.User;
import com.gic.ems.service.M02_Service;
import com.gic.ems.web.model.M02_PwdChangeModel;

/**
 * The Class M02_ServiceImpl.
 *
 * @author PhuuKhinKhin Jan 27, 2019 <BR>
 * @version 1.0 </BR>
 * @since 2019 </BR>
 *        ems system</BR>
 *        com.gic.ems.service.impl </BR>
 *        M02_ServiceImpl.java </BR>
 */
@Service
public class M02_ServiceImpl implements M02_Service {

	/** The user dao. */
	private UserDao userDao;

	/** The password encoder. */
	private PasswordEncoder passwordEncoder;

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
	 * Sets the password encoder.
	 *
	 * @param passwordEncoder the new password encoder
	 */
	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.gic.ems.service.M02_Service#update(com.gic.ems.web.model.
	 * M02_PasswordUpdateModel)
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(M02_PwdChangeModel m02Model) {
		User user = this.userDao
				.findByEmailAndDeleteFlag(UserUtility.getInstance().getLoginUserName(), DeleteFlag.ACTIVE).orElse(null);
		user.setPassword(this.passwordEncoder.encode(m02Model.getNewPassword()));
		this.userDao.save(user);
	}
}