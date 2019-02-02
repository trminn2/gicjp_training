package com.gic.ems.service;

import java.util.Collection;

import javax.validation.Valid;

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
	public Collection<M09_HakenCreateModel> findAllCompany(@NonNull M09_HakenCreateModel hakenModel);

	/**
	 * Save.
	 *
	 * @param hakenModel the haken model
	 */
	void save(@NonNull M09_HakenCreateModel hakenModel) throws Exception;

	M09_HakenCreateModel findDispatchDepartment(@NonNull Long id);

	void update(@Valid M09_HakenCreateModel hakenModel);
}