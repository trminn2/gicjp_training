package com.gic.ems.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gic.ems.common.type.DateFormat;
import com.gic.ems.common.type.DeleteFlag;
import com.gic.ems.common.utility.DateUtility;
import com.gic.ems.dao.CompanyDao;
import com.gic.ems.dao.DispatchDao;
import com.gic.ems.dao.DispatchDepartmentDao;
import com.gic.ems.dao.EmpGroupDao;
import com.gic.ems.dao.EmployeeDao;
import com.gic.ems.entity.Company;
import com.gic.ems.entity.Dispatch;
import com.gic.ems.entity.DispatchDepartment;
import com.gic.ems.entity.EmpGroup;
import com.gic.ems.entity.Employee;
import com.gic.ems.service.M14_Service;
import com.gic.ems.web.model.M14_EmpHakenModel;

/**
 * The Class M14_ServiceImpl.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since Feb 3, 2019 </BR>
 *        ems system </BR>
 *        com.gic.ems.service.impl </BR>
 *        M14_ServiceImpl.java </BR>
 */
@Service
public class M14_ServiceImpl implements M14_Service {

	/** The company dao. */
	private CompanyDao companyDao;

	/** The emp group dao. */
	private EmpGroupDao empGroupDao;

	/** The employee dao. */
	private EmployeeDao employeeDao;

	/** The dispatch dao. */
	private DispatchDao dispatchDao;

	/** The dispatch department dao. */
	private DispatchDepartmentDao dispatchDepartmentDao;

	/**
	 * Sets the company dao.
	 *
	 * @param companyDao the new company dao
	 */
	@Autowired
	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

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

	/**
	 * Sets the dispatch dao.
	 *
	 * @param dispatchDao the new dispatch dao
	 */
	@Autowired
	public void setDispatchDao(DispatchDao dispatchDao) {
		this.dispatchDao = dispatchDao;
	}

	/**
	 * Sets the dispatch department dao.
	 *
	 * @param dispatchDepartmentDao the new dispatch department dao
	 */
	@Autowired
	public void setDispatchDepartmentDao(DispatchDepartmentDao dispatchDepartmentDao) {
		this.dispatchDepartmentDao = dispatchDepartmentDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gic.ems.service.M14_Service#findAllCompanies()
	 */
	@Override
	public Collection<Company> findAllCompanies() {
		return this.companyDao.findAllByDeleteFlag(DeleteFlag.ACTIVE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gic.ems.service.M14_Service#findAllDispatchDepartments()
	 */
	@Override
	public Collection<DispatchDepartment> findAllDispatchDepartments() {
		return this.dispatchDepartmentDao.findByDeleteFlag(DeleteFlag.ACTIVE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gic.ems.service.M14_Service#findAllEmpGroups()
	 */
	@Override
	public Collection<EmpGroup> findAllEmpGroups() {
		return this.empGroupDao.findByDeleteFlag(DeleteFlag.ACTIVE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.gic.ems.service.M14_Service#findByEmployeeIdContaining(java.lang.String)
	 */
	@Override
	public Collection<Employee> findByEmployeeIdContaining(String employeeCode) {
		return this.employeeDao.findByEmployeeCodeAndDeleteFlagContaining(employeeCode, DeleteFlag.ACTIVE);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.gic.ems.service.M14_Service#findById(java.lang.Long)
	 */
	@Override
	public M14_EmpHakenModel findById(Long id) {
		Dispatch dispatch = this.dispatchDao.findById(id).orElse(null);

		return M14_EmpHakenModel.builder().id(dispatch.getId()).companyCode(dispatch.getCompany().getId())
				.dispatchDeptId(dispatch.getDispatchDepartment().getId()).groupId(dispatch.getEmpGroup().getId())
				.employeeCode(dispatch.getEmployee().getEmployeeCode())
				.dispatchStartDate(DateUtility.getInstance().convertLocaleDateToString(dispatch.getDispatchStartDate(),
						DateFormat.DDMMYYYY))
				.dispatchEndDate(DateUtility.getInstance().convertLocaleDateToString(dispatch.getDispatchEndDate(),
						DateFormat.DDMMYYYY))
				.income(dispatch.getIncome().toString()).build();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.gic.ems.service.M14Service#save(com.gic.ems.web.model.
	 * M14_EmpHakenCreateModel)
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void save(M14_EmpHakenModel m14Model) {
		this.dispatchDao.save(Dispatch.builder()
				.employee(
						this.employeeDao.findByEmployeeCodeAndDeleteFlag(m14Model.getEmployeeCode(), DeleteFlag.ACTIVE))
				.empGroup(EmpGroup.builder().id(Long.valueOf(m14Model.getGroupId())).build())
				.dispatchDepartment(DispatchDepartment.builder().id(Long.valueOf(m14Model.getDispatchDeptId())).build())
				.company(Company.builder().id(Long.valueOf(m14Model.getCompanyCode())).build())
				.dispatchStartDate(DateUtility.getInstance().convertStringToLocaleDate(m14Model.getDispatchStartDate(),
						DateFormat.DDMMYYYY))
				.dispatchEndDate(DateUtility.getInstance().convertStringToLocaleDate(m14Model.getDispatchEndDate(),
						DateFormat.DDMMYYYY))
				.income(Double.valueOf(m14Model.getIncome())).build());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.gic.ems.service.M14Service#eidt(com.gic.ems.web.model.
	 * M14_EmpHakenCreateModel)
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(M14_EmpHakenModel m14Model) {
		this.dispatchDao.save(Dispatch.builder().id(m14Model.getId())
				.employee(
						this.employeeDao.findByEmployeeCodeAndDeleteFlag(m14Model.getEmployeeCode(), DeleteFlag.ACTIVE))
				.empGroup(EmpGroup.builder().id(Long.valueOf(m14Model.getGroupId())).build())
				.dispatchDepartment(DispatchDepartment.builder().id(Long.valueOf(m14Model.getDispatchDeptId())).build())
				.company(Company.builder().id(Long.valueOf(m14Model.getCompanyCode())).build())
				.dispatchStartDate(DateUtility.getInstance().convertStringToLocaleDate(m14Model.getDispatchStartDate(),
						DateFormat.DDMMYYYY))
				.dispatchEndDate(DateUtility.getInstance().convertStringToLocaleDate(m14Model.getDispatchEndDate(),
						DateFormat.DDMMYYYY))
				.income(Double.valueOf(m14Model.getIncome())).build());
	}
}