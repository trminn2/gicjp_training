package com.gic.ems.service;

import java.util.Collection;

import com.gic.ems.entity.Company;
import com.gic.ems.entity.DispatchDepartment;
import com.gic.ems.entity.EmpGroup;
import com.gic.ems.entity.Employee;
import com.gic.ems.web.model.M14_EmpHakenModel;

import lombok.NonNull;

/**
 * The Interface M14_Service.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Jan 26, 2019 </BR>
 *        ems system </BR>
 *        com.gic.ems.service </BR>
 *        M14_Service.java </BR>
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

	/**
	 * Find by employee id containing.
	 *
	 * @param employeeId the employee id
	 * @return Collection
	 */
	Collection<Employee> findByEmployeeIdContaining(String employeeId);

	/**
	 * Find all emp groups.
	 *
	 * @return Collection
	 */
	Collection<EmpGroup> findAllEmpGroups();

	/**
	 * Find all companies.
	 *
	 * @return Collection
	 */
	Collection<Company> findAllCompanies();

	/**
	 * Find all dispatch departments.
	 *
	 * @return Collection
	 */
	Collection<DispatchDepartment> findAllDispatchDepartments();
}