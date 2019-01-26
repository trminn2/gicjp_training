package com.gic.ems.service;

import com.gic.ems.web.model.M13_CustCreateModel;

/**
 * The Interface M13Service.
 *
 * @author THAEMYATNOELWIN Jan 26, 2019 <BR>
 *         The Interface M15Service.
 */
public interface M13_Service {

	/**
	 * Save.
	 *
	 * @param custCreateModel the cust create model
	 */
	void save(M13_CustCreateModel custCreateModel);
	
	/**
	 * Edit.
	 *
	 * @param custCreateModel the cust create model
	 */
	void edit(M13_CustCreateModel custCreateModel);

}