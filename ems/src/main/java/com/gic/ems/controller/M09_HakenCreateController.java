package com.gic.ems.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gic.ems.common.constant.ControllerConstant;

import com.gic.ems.web.model.M09_HakenCreateModel;

@Controller
public class M09_HakenCreateController {

	/*@Autowired
	MG09_HakenCreateService service;
	*/
	@GetMapping(value = "/MG09")
	public String hakenCreate(Model model) {
		return "M09-haken-create";
	}
	
	/*@RequestMapping(value = "/createHaken" , method = RequestMethod.POST)
	public String createHaken(@Valid @ModelAttribute M09_HakenCreateModel hakenModel,
			BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {

			model.addAttribute("employeeId", hakenModel);
			model.addAttribute("m04Model", hakenModel);
			return ControllerConstant.MG004_EMPLOYEE_INTIAL_INFO;
		} else {
			//service.save(hakenModel);
		}
		return ControllerConstant.MG004_EMPLOYEE_INTIAL_INFO;
	}*/
	
}
