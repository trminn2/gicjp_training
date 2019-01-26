package com.gic.ems.service;

import com.gic.ems.web.model.M14_EmpHakenCreateModel;

/**
 * The Interface M14Service.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 *         The Interface M14Service.
 */
public interface M14Service {

	/**
	 * Save.
	 *
	 * @param m14Model the m 14 model
	 */
	void save(M14_EmpHakenCreateModel m14Model);

	/**
	 * Eidt.
	 *
	 * @param m14Model the m 14 model
	 */
	void eidt(M14_EmpHakenCreateModel m14Model);
}