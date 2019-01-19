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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.gic.ems.common.constant.ControllerConstant;
import com.gic.ems.service.MG004Service;
import com.gic.ems.web.model.M04_EmpCreateModel;

@Controller
public class M04_EmpCreateController {
	@Autowired
	MG004Service service;
	@Autowired
	private MessageSource messageSource;

	@GetMapping(value = { "/MG004", "/MG004" })
	public String MG004(Model model) {
		String msg04 = messageSource.getMessage("msg04", null, Locale.JAPAN);
		model.addAttribute("message", msg04);
		model.addAttribute("m04Model", new M04_EmpCreateModel());
		return ControllerConstant.MG004_EMPLOYEE_INTIAL_INFO;
	}

	@RequestMapping(value = "/createEmployee" , method = RequestMethod.POST)
	public String createEmployee(@Valid @ModelAttribute M04_EmpCreateModel empModel,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			String msg04 = messageSource.getMessage("msg04", null, Locale.JAPAN);
			model.addAttribute("message", msg04);
			//model.addAttribute("error", bindingResult.getFieldError());
			model.addAttribute("employeeId", empModel.getEmployeeId());
			model.addAttribute("m04Model", empModel);
			return ControllerConstant.MG004_EMPLOYEE_INTIAL_INFO;
		} else {
			service.save(empModel);
		}
		return ControllerConstant.MG004_EMPLOYEE_INTIAL_INFO;
	}
}