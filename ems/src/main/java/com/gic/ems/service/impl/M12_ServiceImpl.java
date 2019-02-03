package com.gic.ems.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gic.ems.common.type.DeleteFlag;
import com.gic.ems.dao.EmployeeDao;
import com.gic.ems.entity.Employee;
import com.gic.ems.service.M12_Service;

/**
 * The Class M12_ServiceImpl.
 *
 * @author MOEPWINTPHYU Jan 26, 2019 <BR>
 *         The Class M12_ServiceImpl.
 */
@Service
public class M12_ServiceImpl implements M12_Service {

	/** The employee dao. */
	private EmployeeDao employeeDao;

	/*
	 * (non-Javadoc)
	 *
	 * @see com.gic.ems.service.M12_Service#findById(java.lang.Long)
	 */
	@Override
	public Optional<Employee> findById(Long id) {
		return this.employeeDao.findByIdAndDeleteFlag(id, DeleteFlag.ACTIVE);
	}

	/**
	 * Gets the employee dao.
	 *
	 * @return the employee dao
	 */
	@Autowired
	public EmployeeDao getEmployeeDao() {
		return this.employeeDao;
	}
}