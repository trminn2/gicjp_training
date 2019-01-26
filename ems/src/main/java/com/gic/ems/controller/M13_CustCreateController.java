package com.gic.ems.controller;


import java.util.Locale;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.gic.ems.common.constant.ControllerConstant;
import com.gic.ems.service.M13_Service;
import com.gic.ems.web.model.M13_CustCreateModel;

/**
 * @author thaemyatnoelwin
 *
 */
@Controller
public class M13_CustCreateController {
	
	@Autowired
	private M13_Service service;
	
	@GetMapping("/create-customer")
	public String init(Model model,Locale locale) {
		model.addAttribute(ControllerConstant.M13_MODEL, M13_CustCreateModel.builder().build());
		return ControllerConstant.M13_CUSTOMER_CREATE;
	}
	
	@PostMapping("/create-customer")
	public String createCustomer(@Valid @ModelAttribute M13_CustCreateModel customerModel,
			BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("companyName", customerModel.getCompanyName());
			model.addAttribute(ControllerConstant.M13_MODEL, customerModel);
		} else {
			service.save(customerModel);
		}
		return ControllerConstant.M13_CUSTOMER_CREATE;
	}
}