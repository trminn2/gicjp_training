package com.gic.ems.controller;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.gic.ems.common.constant.ControllerConstant;
import com.gic.ems.service.M15_Service;
import com.gic.ems.web.model.M15_CustomerListModel;

import lombok.NonNull;

/**
 * The Class M15_CustListController.</BR>
 *
 * @author THAEMYATNOELWIN </BR>
 * @version 1.0 </BR>
 * @since Feb 2, 2019 </BR>
 *        ems system </BR>
 *        com.gic.ems.controller </BR>
 *        M15_CustListController.java </BR>
 */
@Controller
public class M15_CustListController extends BaseController {

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
	public String init(@ModelAttribute M15_CustomerListModel m15Model, Model model) {
		if (null == m15Model) {
			model.addAttribute(ControllerConstant.M15_MODEL, M15_CustomerListModel.builder().build());
			model.addAttribute(ControllerConstant.M15_MODEL_LIST, CollectionUtils.EMPTY_COLLECTION);
		} else {
			model.addAttribute(ControllerConstant.M15_MODEL, m15Model);
			model.addAttribute(ControllerConstant.M15_MODEL_LIST, this.service.findAll(m15Model));
		}
		return ControllerConstant.M15_CUSTOMER_INFO_SEARCH;
	}

	@GetMapping("/{id}/cust-list")
	public String edit(@PathVariable("id") @NonNull String id, Model model) {
		return super.redirectURL(id, ControllerConstant.CUST_EDIT);
	}
}