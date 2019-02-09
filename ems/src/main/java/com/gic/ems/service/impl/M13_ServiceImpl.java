package com.gic.ems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gic.ems.common.type.DateFormat;
import com.gic.ems.common.type.DeleteFlag;
import com.gic.ems.common.utility.CodeUtility;
import com.gic.ems.common.utility.DateUtility;
import com.gic.ems.dao.CompanyDao;
import com.gic.ems.entity.Company;
import com.gic.ems.service.M13_Service;
import com.gic.ems.web.model.M13_CustCreateModel;

import lombok.NonNull;

/**
 * The Class M13_ServiceImpl.
 *
 * @author ThaeMyatNoeLwin Jan 27, 2019 <BR>
 *         The Class M13_ServiceImpl.
 */
@Service
public class M13_ServiceImpl implements M13_Service {

	/** The company dao. */
	private CompanyDao companyDao;

	/**
	 * Sets the company dao.
	 *
	 * @param companyDao the new company dao
	 */
	@Autowired
	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.gic.ems.service.M13_Service#save(com.gic.ems.web.model.
	 * M13_CustCreateModel)
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void save(M13_CustCreateModel custCreateModel) {
		Company company = Company.builder()
				.companyCode(CodeUtility.getInstance().generateCompanyCode(this.companyDao.count()))
				.companyName(custCreateModel.getCompanyName()).contactEmail(custCreateModel.getContactEmail())
				.contactPersonFirstName(custCreateModel.getContactPersonFirstName())
				.address(custCreateModel.getAddress())
				.contactPersonFirstNameKana(custCreateModel.getContactPersonFirstNameKana())
				.contactPersonLastName(custCreateModel.getContactPersonLastName())
				.contactPersonLastNameKana(custCreateModel.getContactPersonLastNameKana())
				.contractStartDate(DateUtility.getInstance()
						.convertStringToLocaleDate(custCreateModel.getContractStartDate(), DateFormat.DDMMYYYY))
				.postalCode(custCreateModel.getPostalCode()).contactPhone(custCreateModel.getContactPhone()).build();
		this.companyDao.save(company);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.gic.ems.service.M13_Service#edit(com.gic.ems.web.model.
	 * M13_CustCreateModel)
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void update(M13_CustCreateModel custCreateModel) {
		// TODO Auto-generated method stub
		Company company = Company.builder()
				.id(custCreateModel.getId())
				.companyCode(CodeUtility.getInstance().generateCompanyCode(this.companyDao.count()))
				.companyName(custCreateModel.getCompanyName()).contactEmail(custCreateModel.getContactEmail())
				.contactPersonFirstName(custCreateModel.getContactPersonFirstName())
				.address(custCreateModel.getAddress())
				.contactPersonFirstNameKana(custCreateModel.getContactPersonFirstNameKana())
				.contactPersonLastName(custCreateModel.getContactPersonLastName())
				.contactPersonLastNameKana(custCreateModel.getContactPersonLastNameKana())
				.postalCode(custCreateModel.getPostalCode()).contactPhone(custCreateModel.getContactPhone()).build();
		this.companyDao.save(company);
	}

	@Override
	public M13_CustCreateModel findById(@NonNull Long id) {
		Company company =  this.companyDao.save(this.companyDao.findByIdAndDeleteFlag(id, DeleteFlag.ACTIVE));
		M13_CustCreateModel m13_CustCreateModel= M13_CustCreateModel.builder()
		.id(company.getId())
		.companyName(company.getCompanyName())
		.address(company.getAddress())
		.postalCode(company.getPostalCode())
		.contactEmail(company.getContactEmail())
		.contactPersonFirstName(company.getContactPersonFirstName())
		.contactPersonFirstNameKana(company.getContactPersonFirstNameKana())
		.contactPersonLastName(company.getContactPersonLastName())
		.contactPersonLastNameKana(company.getContactPersonLastNameKana())
		.contactPhone(company.getContactPhone()).build();
		return m13_CustCreateModel;
	}
}