package com.gic.ems.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
		List<M15_CustomerListModel> list = new ArrayList<>();
		
		List<Company> companyList = this.companyDao.findAll();
		
		for (Company company : companyList) {
			list.add(M15_CustomerListModel.builder().companyName(company.getCompanyName()).build());
		}
		return list;
	}

}
