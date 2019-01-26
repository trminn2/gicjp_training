package com.gic.ems.service;

import com.gic.ems.web.model.M02_PasswordUpdateModel;

import lombok.NonNull;

/**
 * The Interface M02_Service.
 *
 * @author PhuuKhinKhin Jan 26, 2019 <BR>
 *         The Interface M02_Service.
 */
public interface M02_Service {

	/**
	 * Update.
	 *
	 * @param m02Model the m 02 model
	 * @return true, if successful
	 */
	public boolean update(@NonNull M02_PasswordUpdateModel m02Model);
}