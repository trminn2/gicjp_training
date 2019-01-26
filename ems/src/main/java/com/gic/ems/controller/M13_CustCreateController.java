package com.gic.ems.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
	M13_Service service;
	@Autowired(required=false)
	private MessageSource messageSource;
	
	@GetMapping("/cust-register")
	public String init(Model model) {
		String msg04 = messageSource.getMessage("msg04", null, Locale.JAPAN);
		model.addAttribute("message", msg04);
		model.addAttribute("m04Model", new M13_CustCreateModel());
		return ControllerConstant.M13_CUSTOMER_REGISTER;
	}
	
	@PostMapping("/createCustomer")
	public String createCustomer(@Valid @ModelAttribute M13_CustCreateModel customerModel,
			BindingResult bindingResult, Model model) {

		return ControllerConstant.M13_CUSTOMER_REGISTER;
	}
	
	
	@PostMapping("/updateCustomer")
	public String updateCustomer(@Valid @ModelAttribute M13_CustCreateModel customerModel,
			BindingResult bindingResult, Model model) {
		
		return ControllerConstant.M13_CUSTOMER_REGISTER;
	}
	
}
