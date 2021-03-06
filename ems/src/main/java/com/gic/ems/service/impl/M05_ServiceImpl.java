package com.gic.ems.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gic.ems.common.constant.Constant;
import com.gic.ems.common.type.DeleteFlag;
import com.gic.ems.dao.EmpGroupDao;
import com.gic.ems.dao.EmployeeDao;
import com.gic.ems.entity.EmpGroup;
import com.gic.ems.entity.Employee;
import com.gic.ems.service.M05_Service;
import com.gic.ems.web.model.M05_EmpListModel;

/**
 * The Class M05_ServiceImpl.
 *
 * @author ThaeMyatNoeLwin Jan 27, 2019 <BR>
 *         The Class M05_ServiceImpl.
 */
@Service
public class M05_ServiceImpl implements M05_Service {

	/** The emp group dao. */
	private EmpGroupDao empGroupDao;

	/** The employee dao. */
	private EmployeeDao employeeDao;

	/**
	 * Sets the emp group dao.
	 *
	 * @param empGroupDao the new emp group dao
	 */
	@Autowired
	public void setEmpGroupDao(EmpGroupDao empGroupDao) {
		this.empGroupDao = empGroupDao;
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

	/*
	 * (non-Javadoc)
	 *
	 * @see com.gic.ems.service.M05_Service#findAll(com.gic.ems.web.model.
	 * M05_EmpListModel)
	 */
	@Override
	public Collection<M05_EmpListModel> findAll(M05_EmpListModel searchModel) {

		List<M05_EmpListModel> list = new ArrayList<>();

		List<Employee> empList = this.employeeDao.findAll();
		// TODO delete after developing
		for (Employee emp : empList) {
			if (null == emp.getEmpGroup()) {
				continue;
			}
			EmpGroup empGroup = this.empGroupDao
					.findByIdAndDeleteFlag(Long.valueOf(emp.getEmpGroup().getId()), DeleteFlag.ACTIVE).orElse(null);
			String email = (null != emp.getUser()) ? emp.getUser().getEmail() : Constant.EMPTY_STRING;
			list.add(M05_EmpListModel.builder().id(emp.getId()).employeeCode(emp.getEmployeeCode()).firstName(emp.getFirstName())
					.lastName(emp.getLastName()).email(email).gender(emp.getGender()).groupName(empGroup.getName())
					.build());

		}
		return list;
	}
}