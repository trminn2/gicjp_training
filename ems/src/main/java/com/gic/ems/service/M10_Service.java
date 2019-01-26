package com.gic.ems.service;

import java.util.Collection;

import com.gic.ems.web.model.M10_HakenInfoSearchModel;

import lombok.NonNull;

/**
 * The Interface M10_Service.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 *         The Interface M10_Service.
 */
public interface M10_Service {

	/**
	 * Search.
	 *
	 * @param model the model
	 * @return Collection
	 */
	Collection<M10_HakenInfoSearchModel> findAll(@NonNull M10_HakenInfoSearchModel model);
}