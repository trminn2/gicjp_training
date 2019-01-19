package com.gic.ems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gic.ems.common.utility.UserUtility;
import com.gic.ems.dao.UserDao;
import com.gic.ems.entity.User;
import com.gic.ems.service.M02Service;
import com.gic.ems.web.model.M02_PasswordUpdateModel;

@Service
public class M02ServiceImpl implements M02Service {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserUtility userUtility;

	@Override
	public boolean update(M02_PasswordUpdateModel m02Model) {
		User user = this.userDao.findById(userUtility.getLoginUserId()).orElse(null);
		if (null != user) {
			// TODO
			// user.setPassword(m02Model.getNewPassword());
			return true;
		} else {
			return false;
		}
	}
}