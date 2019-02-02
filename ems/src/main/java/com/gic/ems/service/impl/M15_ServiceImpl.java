package com.gic.ems.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gic.ems.common.type.DeleteFlag;
import com.gic.ems.dao.CompanyDao;
import com.gic.ems.entity.Company;
import com.gic.ems.service.M15_Service;
import com.gic.ems.web.model.M15_CustomerListModel;

/**
 * @author thaemyatnoelwin
 *
 */
@Service
public class M15_ServiceImpl implements M15_Service {

	/**
	 * 
	 */
	@Autowired
	private CompanyDao companyDao;

	@Override
	public Collection<M15_CustomerListModel> findAll(M15_CustomerListModel searchModel) {
		Collection<M15_CustomerListModel> list = new ArrayList<>();

		Collection<Company> companyList = this.companyDao.findAllByDeleteFlag(DeleteFlag.ACTIVE);

		for (Company company : companyList) {
			list.add(M15_CustomerListModel.builder()
					.companyName(company.getCompanyName())
					.address(company.getAddress())
					.postalCode(company.getPostalCode())
					.contactEmail(company.getContactEmail())
					.contactPersonFirstName(company.getContactPersonFirstName())
					.contactPersonFirstNameKana(company.getContactPersonFirstNameKana())
					.contactPersonLastName(company.getContactPersonLastName())
					.contactPersonLastNameKana(company.getContactPersonLastNameKana())
					.contractStartDate(company.getContractStartDate())
					.contactPhone(company.getContactPhone())
					.build());
		}
		return list;
	}

}
