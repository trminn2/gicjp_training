package com.gic.ems.controller;


import java.util.Locale;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.gic.ems.common.constant.ControllerConstant;
import com.gic.ems.service.M13_Service;
import com.gic.ems.web.model.M13_CustCreateModel;

/**
 * The Class M15_CustEditController.
 *
 * @author THAEMYATNOELWIN Jan 26, 2019 <BR>
 *         The Class M13_CustEditController.
 */
@Controller
public class M13_CustEditController {
	
	@Autowired
	M13_Service service;
	
	/**
	 * Inits the.
	 *
	 * @param id     the id
	 * @param model  the model
	 * @param locale the locale
	 * @return String
	 */
	@GetMapping("/{id}/cust-edit")
	public String init(@PathVariable String id, Model model,Locale locale) {
		return ControllerConstant.M13_CUSTOMER_EDIT;
	}
	
	/**
	 * Edits the.
	 *
	 * @param id     the id
	 * @param model  the model
	 * @param locale the locale
	 * @return String
	 */
	@PostMapping("/{id}/cust-edit")
	public String edit(@PathVariable String id, Model model,Locale locale) {
		return ControllerConstant.M13_CUSTOMER_EDIT;
	}
}