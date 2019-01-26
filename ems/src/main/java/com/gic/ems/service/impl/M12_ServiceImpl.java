package com.gic.ems.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gic.ems.dao.EmployeeDao;
import com.gic.ems.entity.Employee;
import com.gic.ems.service.M12_Service;

@Service
public class M12_ServiceImpl implements M12_Service {

	/** The employee dao. */
	@Autowired
	private EmployeeDao employeeDao;

	public Optional<Employee> findById(Long id) {
		return employeeDao.findById(id);
	}
}