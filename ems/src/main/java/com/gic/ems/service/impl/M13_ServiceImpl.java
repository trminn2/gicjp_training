package com.gic.ems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gic.ems.dao.CompanyDao;
import com.gic.ems.entity.Company;
import com.gic.ems.service.M13_Service;
import com.gic.ems.web.model.M13_CustCreateModel;

@Service
public class M13_ServiceImpl implements M13_Service {
	
	/** The company dao. */
	@Autowired
	private CompanyDao companyDao;
	@Override
	public void save(M13_CustCreateModel custCreateModel) {
		Company company = Company.builder().companyId(custCreateModel.getCompanyId()).companyName(custCreateModel.getCompanyName()).contactEmail(custCreateModel.getContactEmail())
				.contactPersonFirstName(custCreateModel.getContactPersonFirstName()).address(custCreateModel.getAddress()).contactPersonFirstNameKana(custCreateModel.getContactPersonFirstNameKana()).contactPersonLastName(custCreateModel.getContactPersonLastName()).contactPersonLastNameKana(custCreateModel.getContactPersonLastNameKana()).postalCode(custCreateModel.getPostalCode()).contactPhone(custCreateModel.getContactPhone()).build();
		this.companyDao.save(company);
	}
}