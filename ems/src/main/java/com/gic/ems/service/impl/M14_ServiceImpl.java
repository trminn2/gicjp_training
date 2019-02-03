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
 * The Class M14ServiceImpl.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 *         The Class M14ServiceImpl.
 */
@Service
public class M14_ServiceImpl implements M14_Service {

	private EmpGroupDao groupDao;
	private CompanyDao companyDao;
	private EmployeeDao employeeDao;
	private DispatchDao dispatchDao;
	private DispatchDepartmentDao dispatchDepartmentDao;

	@Override
	public Collection<Company> findAllCompanies() {
		return this.companyDao.findAllByDeleteFlag(DeleteFlag.ACTIVE);
	}

	@Override
	public Collection<DispatchDepartment> findAllDispatchDepartments() {
		return this.dispatchDepartmentDao.findByDeleteFlag(DeleteFlag.ACTIVE);
	}

	@Override
	public Collection<EmpGroup> findAllEmpGroups() {
		return this.groupDao.findByDeleteFlag(DeleteFlag.ACTIVE);
	}

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

		return M14_EmpHakenModel.builder().id(dispatch.getId()).companyId(dispatch.getCompany().getId())
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
				.company(Company.builder().id(Long.valueOf(m14Model.getCompanyId())).build())
				.dispatchStartDate(DateUtility.getInstance().convertStringToLocaleDate(m14Model.getDispatchStartDate(),
						DateFormat.DDMMYYYY))
				.dispatchEndDate(DateUtility.getInstance().convertStringToLocaleDate(m14Model.getDispatchEndDate(),
						DateFormat.DDMMYYYY))
				.income(Double.valueOf(m14Model.getIncome())).build());
	}

	@Autowired
	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	@Autowired
	public void setDispatchDao(DispatchDao dispatchDao) {
		this.dispatchDao = dispatchDao;
	}

	@Autowired
	public void setDispatchDepartmentDao(DispatchDepartmentDao dispatchDepartmentDao) {
		this.dispatchDepartmentDao = dispatchDepartmentDao;
	}

	@Autowired
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Autowired
	public void setGroupDao(EmpGroupDao groupDao) {
		this.groupDao = groupDao;
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
				.company(Company.builder().id(Long.valueOf(m14Model.getCompanyId())).build())
				.dispatchStartDate(DateUtility.getInstance().convertStringToLocaleDate(m14Model.getDispatchStartDate(),
						DateFormat.DDMMYYYY))
				.dispatchEndDate(DateUtility.getInstance().convertStringToLocaleDate(m14Model.getDispatchEndDate(),
						DateFormat.DDMMYYYY))
				.income(Double.valueOf(m14Model.getIncome())).build());
	}
}