package com.gic.ems.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gic.ems.service.M07_Service;
import com.gic.ems.web.model.M07_EmpInfoCreateModel;

@Service
public class M07_ServiceImpl implements M07_Service{

	
	@Override
	@Transactional
	public void save(M07_EmpInfoCreateModel model) {
		
	}
}
