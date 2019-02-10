package com.gic.ems.service;

import java.util.Collection;

import com.gic.ems.web.model.M05_EmpListModel;

import lombok.NonNull;

/**
 * The Interface M05_Service.
 *
 * @author ThaeMyatNoeLwin Jan 27, 2019 <BR>
 *         The Interface M05_Service.
 */
public interface M05_Service {

	/**
	 * Find all.
	 *
	 * @param searchModel the search model
	 * @return Collection
	 */
	Collection<M05_EmpListModel> findAll(@NonNull M05_EmpListModel searchModel);
}