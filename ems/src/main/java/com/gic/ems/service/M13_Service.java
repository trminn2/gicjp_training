package com.gic.ems.service;

import com.gic.ems.web.model.M13_CustCreateModel;

import lombok.NonNull;

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
	void save(@NonNull M13_CustCreateModel custCreateModel);

	/**
	 * Edit.
	 *
	 * @param custCreateModel the cust create model
	 */
	void update(@NonNull M13_CustCreateModel custCreateModel);

	M13_CustCreateModel findById(@NonNull Long id);
}