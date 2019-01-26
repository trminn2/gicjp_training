package com.gic.ems.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gic.ems.common.constant.ControllerConstant;
import com.gic.ems.service.M14_Service;
import com.gic.ems.web.model.M14_EmpHakenModel;

/**
 * The Class M14_EmployeeHakenEditController.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 *         The Class M14_EmployeeHakenEditController.
 */
@Controller
public class M14_EmpHakenEditController {

	/** The service. */
	private M14_Service service;

	/**
	 * Sets the service.
	 *
	 * @param service the new service
	 */
	@Autowired
	public void setService(M14_Service service) {
		this.service = service;
	}

	/**
	 * Inits the.
	 *
	 * @param id     the id
	 * @param model  the model
	 * @param locale the locale
	 * @return String
	 */
	@GetMapping("/{id}/emp-haken-edit")
	public String init(@PathVariable("id") String id, Model model, Locale locale) {
		model.addAttribute(ControllerConstant.M14_MODEL, this.service.findById(Long.valueOf(id)));
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
	public String edit(@PathVariable("id") String id, @ModelAttribute M14_EmpHakenModel m14Model, Model model,
			BindingResult bindingResult, Locale locale) {
		this.service.eidt(m14Model);
		return ControllerConstant.M14_EMPLOYEE_HAKE_EDIT;
	}
}