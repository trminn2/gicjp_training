package com.gic.ems.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gic.ems.common.constant.ControllerConstant;
import com.gic.ems.service.M14_Service;
import com.gic.ems.web.model.M14_EmpHakenModel;

/**
 * The Class M14_EmployeeHakenCreateController.
 *
 * @author PHUKHINKHIN Jan 26, 2019 <BR>
 * @version 1.0 </BR>
 * @since 2019 </BR>
 *        ems system</BR>
 *        com.gic.ems.controller </BR>
 *        M14_EmpHakenCreateController.java </BR>
 */
 
@Controller
public class M14_EmpHakenCreateController {

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
	 * @param model  the model
	 * @param locale the locale
	 * @return String
	 */
	@GetMapping("/emp-haken-create")
	public String init(@ModelAttribute M14_EmpHakenModel m14Model, Model model, Locale locale) {
		model.addAttribute(ControllerConstant.COMPANIES, this.service.findAllCompanies());
		model.addAttribute(ControllerConstant.EMP_GROUPS, this.service.findAllEmpGroups());
		model.addAttribute(ControllerConstant.DISPATCH_DEPARTMENTS, this.service.findAllDispatchDepartments());
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
	public String create(@ModelAttribute M14_EmpHakenModel m14Model, Model model, BindingResult bindingResult,
			Locale locale) {
		this.service.save(m14Model);
		return ControllerConstant.M14_EMPLOYEE_HAKEN_CREATE;
	}
}