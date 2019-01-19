package com.gic.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.gic.ems.common.constant.ControllerConstant;
import com.gic.ems.service.M14Service;
import com.gic.ems.web.model.M14_EmpHakenCreateModel;

@Controller
public class M14_EmpHakenCreateController {

	@Autowired
	private M14Service emphakenservice;

	@GetMapping("/emphaken")
	public String init(Model model) {
		model.addAttribute(ControllerConstant.M14_MODEL, new M14_EmpHakenCreateModel());
		return ControllerConstant.M14_EMPHAKENCREATE;
	}

	@PostMapping(path = "/createEmpHaken")
	public String createEmpHaken(@ModelAttribute M14_EmpHakenCreateModel m14Model, Model model, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("erros", "Error Messages");
		} else {
			emphakenservice.save(m14Model);
		}
		return ControllerConstant.M14_EMPHAKENCREATE;
	}
}