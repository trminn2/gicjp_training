package com.gic.ems.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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

	@GetMapping("/emp-list")
	public String init(@ModelAttribute M05_EmpListModel searchModel, Model model, Locale locale) {
		if (null == searchModel) {
			model.addAttribute(ControllerConstant.M05_MODEL, M05_EmpListModel.builder().build());
			model.addAttribute(ControllerConstant.M05_MODEL_LIST, new ArrayList<>());
		} else {
			model.addAttribute(ControllerConstant.M05_MODEL, searchModel);
			model.addAttribute(ControllerConstant.M05_MODEL_LIST, this.service.findAll(searchModel));

		}
		return ControllerConstant.MG005_EMPLOYEE_LIST_SEARCH;
	}
}