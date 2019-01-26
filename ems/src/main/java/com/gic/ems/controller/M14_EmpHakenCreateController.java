package com.gic.ems.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gic.ems.common.constant.ControllerConstant;
import com.gic.ems.web.model.M14_EmpHakenModel;

/**
 * The Class M14_EmployeeHakenCreateController.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 *         The Class M14_EmployeeHakenCreateController.
 */
@Controller
public class M14_EmpHakenCreateController {

	/**
	 * Inits the.
	 *
	 * @param model  the model
	 * @param locale the locale
	 * @return String
	 */
	@GetMapping("/emp-haken-create")
	public String init(Model model, Locale locale) {
		model.addAttribute(ControllerConstant.M14_MODEL, M14_EmpHakenModel.builder().build());
		return ControllerConstant.M14_EMPLOYEE_HAKEN_CREATE;
	}

	/**
	 * Creates the.
	 *
	 * @param model  the model
	 * @param locale the locale
	 * @return String
	 */
	@PostMapping("/emp-haken-create")
	public String create(Model model, Locale locale) {
		return ControllerConstant.M14_EMPLOYEE_HAKEN_CREATE;
	}
}