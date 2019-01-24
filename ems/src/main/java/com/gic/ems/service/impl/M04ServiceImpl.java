package com.gic.ems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gic.ems.common.constant.Constant;
import com.gic.ems.common.type.Role;
import com.gic.ems.dao.EmployeeDao;
import com.gic.ems.dao.UserDao;
import com.gic.ems.entity.Employee;
import com.gic.ems.entity.User;
import com.gic.ems.service.M04Service;
import com.gic.ems.web.model.M04_EmpCreateModel;

@Service
public class M04ServiceImpl implements M04Service {

	/** The employee dao. */
	@Autowired
	private EmployeeDao employeeDao;

	/** The user dao. */
	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder encoder;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gic.ems.service.M04_EmpCreateService#save(com.gic.ems.web.model.
	 * M04_EmpCreateModel)
	 */
	@Override
	@Transactional
	public void save(M04_EmpCreateModel model) {
		Employee emp = Employee.builder().employeeId(model.getEmployeeId()).firstName(model.getFirstName())
				.firstNameKana(model.getFirstNameKana()).lastName(model.getLastName())
				.lastNameKana(model.getLastNameKana()).gender(model.getGender()).build();
		User user = User.builder().email(model.getEmail()).employee(emp)
				.password(this.encoder.encode(Constant.DEFAULT_PASSWORD)).role(Role.USER).build();
		emp.setUser(user);
		this.employeeDao.save(emp);
		this.userDao.save(user);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gic.ems.service.M04_EmpCreateService#hasAccount(java.lang.String)
	 */
	@Override
	public boolean hasAccount(String email) {
		boolean flag = userDao.existsByEmail(email);
		return flag;
	}
}