package com.gic.ems.service;

import java.util.Collection;

import com.gic.ems.entity.Company;
import com.gic.ems.entity.DispatchDepartment;
import com.gic.ems.entity.EmpGroup;
import com.gic.ems.entity.Employee;
import com.gic.ems.web.model.M14_EmpHakenModel;

import lombok.NonNull;

/**
 * The Interface M14Service.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 *         The Interface M14Service.
 */
public interface M14_Service {

	/**
	 * Save.
	 *
	 * @param m14Model the m 14 model
	 */
	void save(@NonNull M14_EmpHakenModel m14Model);

	/**
	 * Eidt.
	 *
	 * @param m14Model the m 14 model
	 */
	void update(@NonNull M14_EmpHakenModel m14Model);

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return M14_EmpHakenModel
	 */
	M14_EmpHakenModel findById(@NonNull Long id);

	Collection<Employee> findByEmployeeIdContaining(String employeeId);

	Collection<EmpGroup> findAllEmpGroups();

	Collection<Company> findAllCompanies();

	Collection<DispatchDepartment> findAllDispatchDepartments();
}