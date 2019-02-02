package com.gic.ems.service;

import java.util.Collection;

import com.gic.ems.web.model.M15_CustomerListModel;

public interface M15_Service {
	public Collection<M15_CustomerListModel> findAll(M15_CustomerListModel searchModel);
}