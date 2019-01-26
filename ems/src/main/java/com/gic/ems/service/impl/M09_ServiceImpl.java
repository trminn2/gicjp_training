package com.gic.ems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gic.ems.dao.HakenDao;
import com.gic.ems.entity.DispatchDepartment;
import com.gic.ems.service.M09_Service;
import com.gic.ems.web.model.M09_HakenCreateModel;

/**
 * The Class M09_ServiceImpl.
 *
 * @author ThetThetKhine Jan 27, 2019 <BR>
 *         The Class M09_ServiceImpl.
 */
@Service
public class M09_ServiceImpl implements M09_Service {

	/** The haken dao. */
	private HakenDao hakenDao;

	/**
	 * Sets the haken dao.
	 *
	 * @param hakenDao the new haken dao
	 */
	@Autowired
	public void setHakenDao(HakenDao hakenDao) {
		this.hakenDao = hakenDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gic.ems.service.M09_Service#save(com.gic.ems.web.model.
	 * M09_HakenCreateModel)
	 */
	@Override
	@Transactional(noRollbackFor = Exception.class)
	public void save(M09_HakenCreateModel m14Model) {
		// TODO Auto-generated method stub
		// this.hakenDao.save(DispatchDepartment.builder().build());
		DispatchDepartment dispatchDept = DispatchDepartment.builder()
				.dispatchDepartmentId(m14Model.getDispatchDepartmentId()).dispatchDepartmentName(m14Model.getName())
				.postalCode(m14Model.getPostalCode()).address(m14Model.getAddress())
				.contractPersonFirstName(m14Model.getContractPersonFirstName())
				.contractPersonFirstNameKana(m14Model.getContractPersonFirstNameKana())
				.contractPersonLastName(m14Model.getContractPersonLastName())
				.contractPersonLastNameKana(m14Model.getContractPersonLastNameKana())
				.contractPhone(m14Model.getContractPhone()).contractEmail(m14Model.getContractEmail()).build();
		this.hakenDao.save(dispatchDept);
	}
}