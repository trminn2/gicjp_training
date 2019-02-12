package com.gic.ems.service.impl;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gic.ems.common.type.DeleteFlag;
import com.gic.ems.dao.CompanyDao;
import com.gic.ems.dao.DispatchDepartmentDao;
import com.gic.ems.entity.Company;
import com.gic.ems.entity.DispatchDepartment;
import com.gic.ems.service.M09_Service;
import com.gic.ems.web.model.M09_HakenCreateModel;

import lombok.NonNull;

/**
 * The Class M09_ServiceImpl.
 *
 * @author ThetThetKhine Jan 27, 2019 <BR>
 *         The Class M09_ServiceImpl.
 */
@Service
public class M09_ServiceImpl implements M09_Service {

	/** The company dao. */
	private CompanyDao companyDao;

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
	 * @see com.gic.ems.service.M05_Service#findAll(com.gic.ems.web.model.
	 * M05_EmpListModel)
	 */
	@Override
	public Collection<Company> findAllCompany(M09_HakenCreateModel hakenModel) {
		return this.companyDao.findAllByDeleteFlag(DeleteFlag.ACTIVE);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.gic.ems.service.M09_Service#findDispatchDepartment(java.lang.String)
	 */
	@Override
	public M09_HakenCreateModel findDispatchDepartment(@NonNull Long id) {
		DispatchDepartment department = this.dispatchDepartmentDao.findByIdAndDeleteFlag(id, DeleteFlag.ACTIVE);
		M09_HakenCreateModel.builder().id(department.getId()).dispatchDeptName(department.getDispatchDepartmentName())
				.companyId(department.getCompany().getId()).contractEmail(department.getContactEmail())
				.contractPersonFirstName(department.getContactPersonFirstName())
				.contractPersonFirstNameKana(department.getContactPersonFirstNameKana())
				.contractPersonLastName(department.getContactPersonLastName())
				.contractPersonLastName(department.getContactPersonLastName())
				.contractPersonLastNameKana(department.getContactPersonLastNameKana())
				.contractPhone(department.getContactPhone()).address(department.getAddress())
				.postalCode(department.getPostalCode()).dispatchStartDate(department.getDispatchStartDate()).build();

		return null;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.gic.ems.service.M09_Service#save(com.gic.ems.web.model.
	 * M09_HakenCreateModel)
	 */
	@Override
	@Transactional(noRollbackFor = Exception.class)
	public void save(M09_HakenCreateModel m09Model) throws Exception {

		Company company = this.companyDao.findByIdAndDeleteFlag(m09Model.getCompanyId(), DeleteFlag.ACTIVE);
		if (null == company) {
			System.out.println("* Null *");
		}
		// Company company =
		// this.companyDao.findByCompanyNameAndDeleteFlag(m09Model.getCompanyName(),DeleteFlag.ACTIVE);
		this.dispatchDepartmentDao.save(DispatchDepartment.builder()
				.id(m09Model.getId())
				.dispatchDepartmentName(m09Model.getDispatchDeptName()).postalCode(m09Model.getPostalCode())
				.address(m09Model.getAddress()).contactPersonFirstName(m09Model.getContractPersonFirstName())
				.contactPersonFirstNameKana(m09Model.getContractPersonFirstNameKana())
				.contactPersonLastName(m09Model.getContractPersonLastName())
				.contactPersonLastNameKana(m09Model.getContractPersonLastNameKana())
				.contactPhone(m09Model.getContractPhone()).contactEmail(m09Model.getContractEmail())
				.dispatchStartDate(m09Model.getDispatchStartDate())
				.dispatchDepartmentName(m09Model.getDispatchDeptName()).company(company).build());
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.gic.ems.service.M13_Service#edit(com.gic.ems.web.model.
	 * M13_CustCreateModel)
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(M09_HakenCreateModel m09Model) {
		
		Company company = this.companyDao.findByIdAndDeleteFlag(m09Model.getCompanyId(), DeleteFlag.ACTIVE);
		// TODO Auto-generated method stub
		this.dispatchDepartmentDao.save(DispatchDepartment.builder()
				.id(m09Model.getId())
				.dispatchDepartmentName(m09Model.getDispatchDeptName()).postalCode(m09Model.getPostalCode())
				.address(m09Model.getAddress()).contactPersonFirstName(m09Model.getContractPersonFirstName())
				.contactPersonFirstNameKana(m09Model.getContractPersonFirstNameKana())
				.contactPersonLastName(m09Model.getContractPersonLastName())
				.contactPersonLastNameKana(m09Model.getContractPersonLastNameKana())
				.contactPhone(m09Model.getContractPhone()).contactEmail(m09Model.getContractEmail())
				.dispatchStartDate(m09Model.getDispatchStartDate())
				.dispatchDepartmentName(m09Model.getDispatchDeptName()).company(company).build());
	}
}