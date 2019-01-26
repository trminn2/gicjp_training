package com.gic.ems.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gic.ems.service.M09_Service;
import com.gic.ems.web.model.M09_HakenCreateModel;

@Service
public class M09_ServiceImpl implements M09_Service{

	
	@Override
	@Transactional
	public void save(M09_HakenCreateModel model) {
		
	}
}
