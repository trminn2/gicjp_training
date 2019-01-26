package com.gic.ems.service;

import com.gic.ems.web.model.M09_HakenCreateModel;

import lombok.NonNull;

/**
 * The Interface M09_Service.
 *
 * @author ThetThetKhine Jan 27, 2019 <BR>
 *         The Interface M09_Service.
 */
public interface M09_Service {

	/**
	 * Save.
	 *
	 * @param hakenModel the haken model
	 */
	void save(@NonNull M09_HakenCreateModel hakenModel);
}