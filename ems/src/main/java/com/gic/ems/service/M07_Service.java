package com.gic.ems.service;

import com.gic.ems.web.model.M07_EmpInfoCreateModel;

import lombok.NonNull;

/**
 * The Interface M07_Service.
 *
 * @author ThetThetKhine Jan 26, 2019 <BR>
 *         The Interface M07_Service.
 */
public interface M07_Service {

	/**
	 * Save.
	 *
	 * @param empInfoModel the emp info model
	 */
	void save(@NonNull M07_EmpInfoCreateModel empInfoModel);
}