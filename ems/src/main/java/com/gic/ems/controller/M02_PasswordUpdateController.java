package com.gic.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gic.ems.common.constant.ControllerConstant;
import com.gic.ems.service.M02_Service;
import com.gic.ems.web.model.M02_PasswordUpdateModel;

@Controller
public class M02_PasswordUpdateController {

	@Autowired
	private M02_Service userservice;

	@GetMapping(value = { "/passwordupdate" })
	public String init(Model model) {
		model.addAttribute(ControllerConstant.M02_MODEL, new M02_PasswordUpdateModel());
		return ControllerConstant.M02_PASSWORDUPDATE;
	}

	@RequestMapping(path = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute M02_PasswordUpdateModel m02Model, Model model, BindingResult result) {

		if (result.hasErrors()) {
			model.addAttribute("erros", "Error Messages");
		} else {
			this.userservice.update(m02Model);
		}
		return ControllerConstant.M02_PASSWORDUPDATE;
	}
}