package com.gic.ems.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gic.ems.common.constant.ControllerConstant;

/**
 * The Class M14_EmployeeHakenEditController.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 *         The Class M14_EmployeeHakenEditController.
 */
@Controller
public class M14_EmpHakenEditController {

	/**
	 * Inits the.
	 *
	 * @param id     the id
	 * @param model  the model
	 * @param locale the locale
	 * @return String
	 */
	@GetMapping("/{id}/emp-haken-edit")
	public String init(@PathVariable String id, Model model, Locale locale) {
		return ControllerConstant.M14_EMPLOYEE_HAKE_EDIT;
	}

	/**
	 * Edits the.
	 *
	 * @param id     the id
	 * @param model  the model
	 * @param locale the locale
	 * @return String
	 */
	@PostMapping("/{id}/emp-haken-edit")
	public String edit(@PathVariable String id, Model model, Locale locale) {
		return ControllerConstant.M14_EMPLOYEE_HAKE_EDIT;
	}
}