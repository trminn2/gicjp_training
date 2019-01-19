package com.gic.ems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gic.ems.dao.DispatchDao;
import com.gic.ems.entity.Dispatch;
import com.gic.ems.service.M14Service;
import com.gic.ems.web.model.M14_EmpHakenCreateModel;

@Service
public class M14ServiceImpl implements M14Service {
	
	@Autowired
	private DispatchDao dispatchDao;
	
	@Override
	public void save(M14_EmpHakenCreateModel m14Model) {
		Dispatch dispatch=new Dispatch();
		dispatch.setCompanyId(m14Model.getCompanyId());
		dispatch.setDispatchDepartmentId(m14Model.getDispatchDept());
		dispatch.setEmployeeId(m14Model.getEmployeeId());
		dispatch.setGroupId(m14Model.getGroupId());
		dispatch.setDispatchStartDate(m14Model.getDispatchStartDate());
		dispatch.setDispatchEndDate(m14Model.getDispatchEndDate());
		dispatch.setIncome(m14Model.getIncome());
		dispatchDao.save(dispatch);
		
	}

}
