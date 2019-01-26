/*
   * 作成日 : 2019/01/19
   * 作成者 : テッ　テッ　カイン
   * 画面名 : M09_派遣先情報登録画面
 */

package com.gic.ems.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gic.ems.common.constant.ControllerConstant;
import com.gic.ems.service.M09_Service;
import com.gic.ems.web.model.M09_HakenCreateModel;

/**
 * The Class M09_HakenCreateController.
 *
 * @author KYIMINHAN Jan 27, 2019 <BR>
 *         The Class M09_HakenCreateController.
 */
@Controller
public class M09_HakenCreateController {

	/** The service. */
	@Autowired
	private M09_Service service;

	/**
	 * Inits the.
	 *
	 * @param model  the model
	 * @param locale the locale
	 * @return String
	 */
	@GetMapping("/com-haken-create")
	public String init(Model model, Locale locale) {
		model.addAttribute(ControllerConstant.M09_MODEL, M09_HakenCreateModel.builder().build());
		return ControllerConstant.M09_HAKEN_CREATE;
	}

	/**
	 * Creates the company haken.
	 *
	 * @param hakenModel    the haken model
	 * @param bindingResult the binding result
	 * @param model         the model
	 * @return String
	 */
	@PostMapping("/com-haken-create")
	public String create(@Valid @ModelAttribute M09_HakenCreateModel hakenModel, BindingResult bindingResult,
			Model model) {
		this.service.save(hakenModel);
		return ControllerConstant.M09_HAKEN_CREATE;
	}
}