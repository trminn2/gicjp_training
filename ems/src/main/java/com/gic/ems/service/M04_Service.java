package com.gic.ems.service;

import javax.validation.Valid;
import com.gic.ems.web.model.M04_EmpCreateModel;
import lombok.NonNull;

/**
 * The Interface M04_Service.
 *
 * @author MOEPWINTPHYU Jan 27, 2019 <BR>
 *         The Interface M04_Service.
 */
public interface M04_Service {
	/**
	 * Save.
	 *
	 * @param empCreateModel the emp create model
	 */
	void save(@NonNull M04_EmpCreateModel empCreateModel);

	/**
	 * Checks for account.
	 *
	 * @param email the email
	 * @return true, if successful
	 */
	boolean hasAccount(@NonNull String email);
	
	void update(@Valid M04_EmpCreateModel m04Model);
}
