package com.gic.ems.service;

import java.util.Collection;

import com.gic.ems.web.model.M05_EmpListModel;

public interface M05_Service {
	public Collection<M05_EmpListModel> findAll(M05_EmpListModel searchModel);
}