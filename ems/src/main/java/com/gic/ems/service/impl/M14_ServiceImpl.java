package com.gic.ems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gic.ems.dao.DispatchDao;
import com.gic.ems.entity.Dispatch;
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

	/** The dispatch dao. */
	private DispatchDao dispatchDao;

	/**
	 * Sets the dispatch dao.
	 *
	 * @param dispatchDao the new dispatch dao
	 */
	@Autowired
	public void setDispatchDao(DispatchDao dispatchDao) {
		this.dispatchDao = dispatchDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gic.ems.service.M14Service#save(com.gic.ems.web.model.
	 * M14_EmpHakenCreateModel)
	 */
	@Override
	@Transactional(noRollbackFor = Exception.class)
	public void save(M14_EmpHakenModel m14Model) {
		// TODO Auto-generated method stub
		this.dispatchDao.save(Dispatch.builder().build());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gic.ems.service.M14Service#eidt(com.gic.ems.web.model.
	 * M14_EmpHakenCreateModel)
	 */
	@Override
	@Transactional(noRollbackFor = Exception.class)
	public void update(M14_EmpHakenModel m14Model) {
		// TODO Auto-generated method stub
		this.dispatchDao.save(Dispatch.builder().build());
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
}