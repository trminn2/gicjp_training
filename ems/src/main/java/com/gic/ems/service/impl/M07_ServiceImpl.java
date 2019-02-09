package com.gic.ems.service.impl;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gic.ems.common.type.DeleteFlag;
import com.gic.ems.dao.DepartmentDao;
import com.gic.ems.dao.EmpGroupDao;
import com.gic.ems.dao.EmployeeDao;
import com.gic.ems.entity.Department;
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
	private EmpGroupDao empGroupDao;
	
	/** The department dao. */
	private DepartmentDao departmentDao;

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
	 * Sets the group dao.
	 *
	 * @param employeeDao the new employee dao
	 */
	@Autowired
	public void setEmpGroupDao(EmpGroupDao empGroupDao) {
		this.empGroupDao = empGroupDao;
	}

	/**
	 * Sets the department dao.
	 *
	 * @param employeeDao the new employee dao
	 */
	@Autowired
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.gic.ems.service.M07_Service#findAllByDeleteFlag(com.gic.ems.web.model.
	 * M07_EmpInfoCreateModel)
	 */
	@Override
	public Collection<EmpGroup> findAllGroup(M07_EmpInfoCreateModel hakenModel) {
		return this.empGroupDao.findByDeleteFlag(DeleteFlag.ACTIVE);
	}
	
	/*
	 * (non-Javadoc)
	 *
	 * @see com.gic.ems.service.M07_Service#findAllByDeleteFlag(com.gic.ems.web.model.
	 * M07_EmpInfoCreateModel)
	 */
	@Override
	public Collection<Department> findAllDepartment(M07_EmpInfoCreateModel hakenModel) {
		return this.departmentDao.findAllByDeleteFlag(DeleteFlag.ACTIVE);
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
		this.employeeDao.save(Employee.builder()
				.birthDate(model.getBirthDate())
				.firstName(model.getFirstName())
				.firstNameKana(model.getFirstNameKana())
				.lastName(model.getLastName())
				.lastNameKana(model.getLastNameKana())
				.gender(model.getGender())
				.nationality(model.getNationality())
				.phone(model.getPhone())
				.hiredDate(model.getHiredDate())
				.band(model.getBand())
				.residenceNo(model.getResidenceNo())
				.residenceExpire(model.getResidenceExpire())
				.residencePeriod(model.getResidencePeriod())
				.residenceStatus(model.getResidenceStatus())
				.passportType(model.getPassportType())
				.passportNum(model.getPassportNum())
				.passportCountryCode(model.getPassportCountryCode())
				.passportAuthority(model.getPassportAuthority())
				.passportIssuedDate(model.getPassportIssuedDate())
				.passportExpiredDate(model.getPassportExpiredDate())
				.bankAccount(model.getBankAccount())
				.myNumber(model.getMyNumber())
				.insuranceType(model.getInsuranceType())
				.insuredNum(model.getInsuredNum())
				.insuredQualifiedDate(model.getInsuredQualifiedDate())
				.insurerName(model.getInsurerName())
				.postalCode(model.getPostalCode())
				.address(model.getAddress())
				.commuterPassExpiredDate(model.getCommuterPassExpiredDate())
				.startStation(model.getStartStation())
				.endStation(model.getEndStation())
				.build());
	}
}