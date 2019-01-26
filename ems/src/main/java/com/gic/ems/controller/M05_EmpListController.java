package com.gic.ems.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.gic.ems.common.constant.ControllerConstant;
import com.gic.ems.service.M05_Service;
import com.gic.ems.web.model.M05_EmpListModel;

/**
 * @author thaemyatnoelwin
 * @version 1.0 01/12/2019
 */

@Controller
public class M05_EmpListController {

	@Autowired
	private M05_Service service;

	@GetMapping("/empList")
	public String init(Model model, Locale locale) {
		List<M05_EmpListModel> empList = service.findAll();
		model.addAttribute("empList", empList);
		return ControllerConstant.MG005_EMPLOYEE_LIST_SEARCH;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String searchEmp(@ModelAttribute M05_EmpListModel m05_Search, Model model) {
		service.search(m05_Search);
		return ControllerConstant.MG005_EMPLOYEE_LIST_SEARCH;
	}

}
