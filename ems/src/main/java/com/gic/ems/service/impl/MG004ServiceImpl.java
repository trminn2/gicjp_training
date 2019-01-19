package com.gic.ems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gic.ems.dao.EmployeeDao;
import com.gic.ems.entity.Employee;
import com.gic.ems.service.MG004Service;
import com.gic.ems.web.model.M04_EmpCreateModel;

@Service
public class MG004ServiceImpl implements MG004Service {

	@Autowired
	private EmployeeDao empDao;

	@Transactional
	@Override
	public void save(M04_EmpCreateModel model) {
		Employee emp = new Employee();
		emp.setEmployeeId(model.getEmployeeId());
		emp.setFirstName(model.getFirstName());
		emp.setFirstNameKana(model.getFirstNameKana());
		emp.setLastName(model.getLastName());
		emp.setLastNameKana(model.getLastNameKana());
		emp.setGender(model.getGender());
		emp.setEmail(model.getEmail());
		empDao.save(emp);
	}

}