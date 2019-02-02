package com.gic.ems.service.impl;

import java.util.ArrayList;
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

	private CompanyDao companyDao;

	private DispatchDepartmentDao dispatchDepartmentDao;

	@Autowired
	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

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
	public Collection<M09_HakenCreateModel> findAllCompany(M09_HakenCreateModel hakenModel) {

		Collection<M09_HakenCreateModel> list = new ArrayList<>();
		Collection<Company> companyList = this.companyDao.findAllByDeleteFlag(DeleteFlag.ACTIVE);
		for (Company comp : companyList) {
			list.add(M09_HakenCreateModel.builder().companyName(comp.getCompanyName()).build());
		}
		return list;
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
			throw new Exception();
		}
		this.dispatchDepartmentDao.save(DispatchDepartment.builder()
				.dispatchDepartmentName(m09Model.getDispatchDeptName()).postalCode(m09Model.getPostalCode())
				.address(m09Model.getAddress()).contractPersonFirstName(m09Model.getContractPersonFirstName())
				.contractPersonFirstNameKana(m09Model.getContractPersonFirstNameKana())
				.contractPersonLastName(m09Model.getContractPersonLastName())
				.contractPersonLastNameKana(m09Model.getContractPersonLastNameKana())
				.contractPhone(m09Model.getContractPhone()).contractEmail(m09Model.getContractEmail()).company(company)
				.build());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gic.ems.service.M09_Service#findDispatchDepartment(java.lang.String)
	 */
	@Override
	public M09_HakenCreateModel findDispatchDepartment(@NonNull Long id) {
		DispatchDepartment department = this.dispatchDepartmentDao.findByIdAndDeleteFlag(id, DeleteFlag.ACTIVE);
			M09_HakenCreateModel.builder()
			.id(department.getId())
			.dispatchDeptName(department.getDispatchDepartmentName())
			.companyName(department.getCompany().getCompanyName())
			.contractEmail(department.getContractEmail())
			.contractPersonFirstName(department.getContractPersonFirstName())
			.contractPersonFirstNameKana(department.getContractPersonFirstNameKana())
			.contractPersonLastName(department.getContractPersonLastName())
			.contractPersonLastName(department.getContractPersonLastName())
			.contractPersonLastNameKana(department.getContractPersonLastNameKana())
			.contractPhone(department.getContractPhone())
			.address(department.getAddress())
			.postalCode(department.getPostalCode())
			.dispatchStartDate(department.getDispatchStartDate()).build();
			
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gic.ems.service.M09_Service#update(com.gic.ems.web.model.
	 * M09_HakenCreateModel)
	 */
	@Override
	public void update(@Valid M09_HakenCreateModel hakenModel) {
		// TODO Auto-generated method stub

	}
}