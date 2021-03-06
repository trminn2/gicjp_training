package com.gic.ems.service;

import com.gic.ems.web.model.M02_PwdChangeModel;

import lombok.NonNull;

/**
 * The Interface M02_Service.
 *
 * @author PhuuKhinKhin Jan 26, 2019 <BR>
 * @version 1.0 </BR>
 * @since 2019 </BR>
 *        ems system</BR>
 *        com.gic.ems.service </BR>
 *        M02_Service.java </BR>
 */
public interface M02_Service {

	/**
	 * Update.
	 *
	 * @param m02Model the m 02 model
	 *
	 */
	void update(@NonNull M02_PwdChangeModel m02Model);
}