package com.gic.ems.service;

import java.util.Collection;
import com.gic.ems.entity.Department;
import com.gic.ems.entity.EmpGroup;
import com.gic.ems.web.model.M07_EmpInfoCreateModel;
import lombok.NonNull;

/**
 * The Interface M07_Service.
 *
 * @author ThetThetKhine Jan 26, 2019 <BR>
 *         The Interface M07_Service.
 */
public interface M07_Service {
	
	/**
	 * Find all group.
	 *
	 * @param searchModel the search model
	 * @return Collection
	 */
	public Collection<EmpGroup> findAllGroup(@NonNull M07_EmpInfoCreateModel m07Model);

	/**
	 * Find all department.
	 *
	 * @param searchModel the search model
	 * @return Collection
	 */
	public Collection<Department> findAllDepartment(@NonNull M07_EmpInfoCreateModel m07Model);
	
	/**
	 * Save.
	 *
	 * @param empInfoModel the emp info model
	 */
	void save(@NonNull M07_EmpInfoCreateModel empInfoModel);
}