package com.gic.ems.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gic.ems.dao.EmployeeDao;
import com.gic.ems.entity.Employee;
import com.gic.ems.service.M12_Service;

/**
 * The Class M12_ServiceImpl.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 *         The Class M12_ServiceImpl.
 */
@Service
public class M12_ServiceImpl implements M12_Service {

	/** The employee dao. */
	private EmployeeDao employeeDao;

	/**
	 * Gets the employee dao.
	 *
	 * @return the employee dao
	 */
	@Autowired
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gic.ems.service.M12_Service#findById(java.lang.Long)
	 */
	public Optional<Employee> findById(Long id) {
		return employeeDao.findById(id);
	}
}