package com.gic.ems.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.gic.ems.service.M10_Service;
import com.gic.ems.web.model.M10_HakenInfoSearchModel;

/**
 * The Class M10_ServiceImpl.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 *         The Class M10_ServiceImpl.
 */
@Service
public class M10_ServiceImpl implements M10_Service {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.gic.ems.service.M10_Service#search(com.gic.ems.web.model.
	 * M10_HakenInfoSearchModel)
	 */
	@Override
	public Collection<M10_HakenInfoSearchModel> findAll(M10_HakenInfoSearchModel model) {
		// TODO Auto-generated method stub
		return null;
	}
}