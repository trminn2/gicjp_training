package com.gic.ems.service;

import java.util.Collection;


import com.gic.ems.web.model.M15_CustomerListModel;
/**
 * The Interface M15_Service.
 *
 * @author ThaeMyatNoeLwin Jan 27, 2019 <BR>
 *         The Interface M05_Service.
 */
public interface M15_Service {
	public Collection<M15_CustomerListModel> findAll(M15_CustomerListModel searchModel);
}