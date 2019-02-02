package com.gic.ems.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gic.ems.common.constant.DateFormat;
import com.gic.ems.common.type.DeleteFlag;
import com.gic.ems.common.utility.DateUtility;
import com.gic.ems.dao.CompanyDao;
import com.gic.ems.dao.DispatchDao;
import com.gic.ems.dao.DispatchDepartmentDao;
import com.gic.ems.dao.EmployeeDao;
import com.gic.ems.dao.GroupDao;
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

	private GroupDao groupDao;
	private CompanyDao companyDao;
	private EmployeeDao employeeDao;
	private DispatchDao dispatchDao;
	private DispatchDepartmentDao dispatchDepartmentDao;

	@Autowired
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}

	@Autowired
	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	@Autowired
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Autowired
	public void setDispatchDao(DispatchDao dispatchDao) {
		this.dispatchDao = dispatchDao;
	}

	@Autowired
	public void setDispatchDepartmentDao(DispatchDepartmentDao dispatchDepartmentDao) {
		this.dispatchDepartmentDao = dispatchDepartmentDao;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.gic.ems.service.M14_Service#findById(java.lang.Long)
	 */
	@Override
	public M14_EmpHakenModel findById(Long id) {
		// TODO Auto-generated method stub
		return M14_EmpHakenModel.builder().build();
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
		// TODO Auto-generated method stub
		 this.dispatchDao.save(Dispatch.builder()
				 .employee(this.employeeDao.findByEmployeeIdAndDeleteFlag(m14Model.getEmployeeId(), DeleteFlag.ACTIVE))
				 .empGroup(EmpGroup.builder().id(Long.valueOf(m14Model.getGroupId())).build())
				 .dispatchDepartment(DispatchDepartment.builder().id(Long.valueOf(m14Model.getDispatchDeptId())).build())
				 .company(Company.builder().id(Long.valueOf(m14Model.getCompanyId())).build())
				 .dispatchStartDate(DateUtility.getInstance().convertStringToLocaleDate(m14Model.getDispatchStartDate(), DateFormat.YYYY_MM_DD))
				 .dispatchEndDate(DateUtility.getInstance().convertStringToLocaleDate(m14Model.getDispatchEndDate(), DateFormat.YYYY_MM_DD))
				 .income(Double.valueOf(m14Model.getIncome()))
				 .build());

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
		this.dispatchDao.save(Dispatch.builder()
				 .id(m14Model.getId())
				 .employee(Employee.builder().id(Long.valueOf(m14Model.getEmployeeId())).build())
				 .empGroup(EmpGroup.builder().id(Long.valueOf(m14Model.getGroupId())).build())
				 .dispatchDepartment(DispatchDepartment.builder().id(Long.valueOf(m14Model.getDispatchDeptId())).build())
				 .company(Company.builder().id(Long.valueOf(m14Model.getCompanyId())).build())
				 .dispatchStartDate(DateUtility.getInstance().convertStringToLocaleDate(m14Model.getDispatchStartDate(), DateFormat.YYYY_MM_DD))
				 .dispatchEndDate(DateUtility.getInstance().convertStringToLocaleDate(m14Model.getDispatchEndDate(), DateFormat.YYYY_MM_DD))
				 .income(Double.valueOf(m14Model.getIncome()))
				 .build());
	}

	@Override
	public Collection<Employee> findByEmployeeIdContaining(String employeeId) {
		return this.employeeDao.findByEmployeeIdAndDeleteFlagContaining(employeeId, DeleteFlag.ACTIVE);
	}

	@Override
	public Collection<EmpGroup> findAllEmpGroups() {
		return this.groupDao.findByDeleteFlag(DeleteFlag.ACTIVE);
	}

	@Override
	public Collection<Company> findAllCompanies() {
		return this.companyDao.findAllByDeleteFlag(DeleteFlag.ACTIVE);
	}
}