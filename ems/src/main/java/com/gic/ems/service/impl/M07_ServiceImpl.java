package com.gic.ems.service.impl;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gic.ems.common.type.DeleteFlag;
import com.gic.ems.dao.EmpGroupDao;
import com.gic.ems.dao.EmployeeDao;
import com.gic.ems.entity.EmpGroup;
import com.gic.ems.entity.Employee;
import com.gic.ems.service.M07_Service;
import com.gic.ems.web.model.M07_EmpInfoCreateModel;

/**
 * The Class M07_ServiceImpl.
 *
 * @author ThetThetKhine Jan 26, 2019 <BR>
 *         The Class M07_ServiceImpl.
 */
@Service
public class M07_ServiceImpl implements M07_Service {

	/** The employee dao. */
	private EmployeeDao employeeDao;
	
	/** The group dao. */
	private EmpGroupDao groupDao;

	/**
	 * Sets the employee dao.
	 *
	 * @param employeeDao the new employee dao
	 */
	@Autowired
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	/*
	 * (non-Javadoc)
	 *
	 * @see com.gic.ems.service.M07_Service#findAllByDeleteFlag(com.gic.ems.web.model.
	 * M07_EmpInfoCreateModel)
	 */
	@Override
	public Collection<EmpGroup> findAllGroup(M07_EmpInfoCreateModel hakenModel) {
		return this.groupDao.findAllByDeleteFlag(DeleteFlag.ACTIVE);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.gic.ems.service.M07_Service#save(com.gic.ems.web.model.
	 * M07_EmpInfoCreateModel)
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void save(M07_EmpInfoCreateModel model) {
		// TODO to edit for the implementation by THET THET KHINE
		this.employeeDao.save(Employee.builder().build());
	}
}