package com.gic.ems.service.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gic.ems.dao.EmployeeDao;
import com.gic.ems.entity.Employee;
import com.gic.ems.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao empDAO;

	public Employee saveEmployee(Employee theEmployee) {
		
		return empDAO.save(theEmployee);
	}
}