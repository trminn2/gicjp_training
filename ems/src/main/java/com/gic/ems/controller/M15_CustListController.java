package com.gic.ems.controller;

import java.util.Locale;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.gic.ems.common.constant.ControllerConstant;
import com.gic.ems.service.M15_Service;
import com.gic.ems.web.model.M15_CustomerListModel;

/**
 * @author thaemyatnoelwin
 * @version 1.0 01/12/2019
 */

@Controller
public class M15_CustListController {

	/** The service. */
	private M15_Service service;

	/**
	 * Sets the service.
	 *
	 * @param service the new service
	 */
	@Autowired
	public void setService(M15_Service service) {
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
	@GetMapping("/cust-list")
	public String init(@ModelAttribute M15_CustomerListModel searchModel, Model model, Locale local) {
		if (null == searchModel) {
			model.addAttribute(ControllerConstant.M15_MODEL, M15_CustomerListModel.builder().build());
			model.addAttribute(ControllerConstant.M15_MODEL_LIST, CollectionUtils.EMPTY_COLLECTION);
		} else {
			model.addAttribute(ControllerConstant.M15_MODEL, searchModel);
			model.addAttribute(ControllerConstant.M15_MODEL_LIST, this.service.findAll(searchModel));
		}
		return ControllerConstant.M15_CUSTOMER_INFO_SEARCH;
	}
}