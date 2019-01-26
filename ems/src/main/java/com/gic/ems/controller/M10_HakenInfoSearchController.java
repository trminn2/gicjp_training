package com.gic.ems.controller;

import java.util.Locale;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.gic.ems.common.constant.ControllerConstant;
import com.gic.ems.service.M10_Service;
import com.gic.ems.web.model.M10_HakenInfoSearchModel;

/**
 * The Class M10_HakenInfoSearchController.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 *         The Class M10_HakenInfoSearchController.
 */
@Controller
public class M10_HakenInfoSearchController {

	/** The service. */
	private M10_Service service;

	/**
	 * Sets the service.
	 *
	 * @param service the new service
	 */
	@Autowired
	public void setService(M10_Service service) {
		this.service = service;
	}

	/**
	 * Search.
	 *
	 * @param searchModel the search model
	 * @param model       the model
	 * @param local       the local
	 * @return String
	 */
	@GetMapping("/hanken-info-search")
	public String init(@ModelAttribute M10_HakenInfoSearchModel searchModel, Model model, Locale local) {
		if (null == searchModel) {
			model.addAttribute(ControllerConstant.M10_MODEL, M10_HakenInfoSearchModel.builder().build());
			model.addAttribute(ControllerConstant.M10_MODEL_LIST, CollectionUtils.EMPTY_COLLECTION);
		} else {

		}
		this.service.search(searchModel);
		return ControllerConstant.M10_HAKEN_INFO_SEARCH;
	}
}