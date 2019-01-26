package com.gic.ems.service;

import com.gic.ems.web.model.M04_EmpCreateModel;

public interface M04_Service {
	/**
	 * Save.
	 *
	 * @param empCreateModel the emp create model
	 */
	void save(M04_EmpCreateModel empCreateModel);

	/**
	 * Checks for account.
	 *
	 * @param email the email
	 * @return true, if successful
	 */
	boolean hasAccount(String email);
}
