package com.gic.ems.service;

import java.util.Collection;

import javax.validation.Valid;

import com.gic.ems.entity.Company;
import com.gic.ems.web.model.M09_HakenCreateModel;

import lombok.NonNull;

/**
 * The Interface M09_Service.
 *
 * @author ThetThetKhine Jan 27, 2019 <BR>
 *         The Interface M09_Service.
 */
public interface M09_Service {

	/**
	 * Find all company.
	 *
	 * @param searchModel the search model
	 * @return Collection
	 */
	Collection<Company> findAllCompany(@NonNull M09_HakenCreateModel m09Model);

	/**
	 * Save.
	 *
	 * @param hakenModel the haken model
	 */
	void save(@NonNull M09_HakenCreateModel m09Model) throws Exception;

	/**
	 * Find dispatch department.
	 *
	 * @param id the id
	 * @return M09_HakenCreateModel
	 */
	M09_HakenCreateModel findDispatchDepartment(@NonNull Long id);

	/**
	 * Update.
	 *
	 * @param m09Model the m 09 model
	 */
	void update(@Valid M09_HakenCreateModel m09Model);
}