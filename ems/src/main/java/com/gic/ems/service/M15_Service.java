package com.gic.ems.service;

import java.util.Collection;

import com.gic.ems.web.model.M15_CustomerListModel;

/**
 * The Class M15_Service.
 *
 * @author THAEMYATNOELWIN Jan 02 , 2019 </BR>
 * @version 1.0 </BR>
 * @since 2019 </BR>
 *        ems system</BR>
 *        com.gic.ems.service </BR>
 *        EmsApplication.java </BR>
 */
public interface M15_Service {

	/**
	 * Find all.
	 *
	 * @param searchModel the search model
	 * @return Collection
	 */
	Collection<M15_CustomerListModel> findAll(M15_CustomerListModel searchModel);
}