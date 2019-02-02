package com.gic.ems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gic.ems.common.constant.Constant;
import com.gic.ems.common.type.Role;
import com.gic.ems.common.utility.CodeUtility;
import com.gic.ems.dao.EmployeeDao;
import com.gic.ems.dao.UserDao;
import com.gic.ems.entity.Employee;
import com.gic.ems.entity.User;
import com.gic.ems.service.M04_Service;
import com.gic.ems.web.model.M04_EmpCreateModel;

/**
 * The Class M04_ServiceImpl.
 *
 * @author MOEPWINTPHYU Jan 27, 2019 <BR>
 *         The Class M04_ServiceImpl.
 */
@Service
public class M04_ServiceImpl implements M04_Service {

	/** The user dao. */
	private UserDao userDao;

	/** The employee dao. */
	private EmployeeDao employeeDao;

	/** The encoder. */
	private PasswordEncoder encoder;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.gic.ems.service.M04_EmpCreateService#hasAccount(java.lang.String)
	 */
	@Override
	public boolean hasAccount(String email) {
		return this.userDao.existsByEmail(email);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.gic.ems.service.M04_EmpCreateService#save(com.gic.ems.web.model.
	 * M04_EmpCreateModel)
	 */
	@Override
	@Transactional
	public void save(M04_EmpCreateModel model) {
		Employee emp = Employee.builder()
				.employeeCode(CodeUtility.getInstance().generateEmployeeCode(this.employeeDao.count()))
				.firstNameKana(model.getFirstNameKana()).lastName(model.getLastName())
				.lastNameKana(model.getLastNameKana()).gender(model.getGender()).build();
		User user = User.builder().email(model.getEmail()).employee(emp)
				.password(this.encoder.encode(Constant.DEFAULT_PASSWORD)).role(Role.USER).build();
		emp.setUser(user);
		this.employeeDao.save(emp);
	}

	/**
	 * Sets the employee dao.
	 *
	 * @param employeeDao the new employee dao
	 */
	@Autowired
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
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

	/**
	 * Sets the user dao.
	 *
	 * @param userDao the new user dao
	 */
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}