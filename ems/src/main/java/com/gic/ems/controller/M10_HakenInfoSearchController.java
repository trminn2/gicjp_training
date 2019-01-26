package com.gic.ems.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.gic.ems.common.constant.ControllerConstant;
import com.gic.ems.web.model.M10_HakenInfoSearchModel;

/**
 * The Class M10_HakenInfoSearchController.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 *         The Class M10_HakenInfoSearchController.
 */
@Controller
public class M10_HakenInfoSearchController {

	/**
	 * Inits the.
	 *
	 * @param model the model
	 * @param local the local
	 * @return String
	 */
	@GetMapping("/hanken-info-search")
	public String init(Model model, Locale local) {

		return ControllerConstant.M10_HAKEN_INFO_SEARCH;
	}

	/**
	 * Search.
	 *
	 * @param searchModel the search model
	 * @param model       the model
	 * @param local       the local
	 * @return String
	 */
	@GetMapping("/hanken-info-search")
	public String search(@ModelAttribute M10_HakenInfoSearchModel searchModel, Model model, Locale local) {

		return ControllerConstant.M10_HAKEN_INFO_SEARCH;
	}
}