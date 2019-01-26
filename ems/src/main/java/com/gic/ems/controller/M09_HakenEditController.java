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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gic.ems.common.constant.ControllerConstant;
import com.gic.ems.service.M09_Service;
import com.gic.ems.web.model.M09_HakenCreateModel;

/**
 * The Class M09_HakenEditController.
 *
 * @author ThetThetKhine Jan 27, 2019 <BR>
 *         The Class M09_HakenEditController.
 */
@Controller
public class M09_HakenEditController {

	/** The service. */
	private M09_Service service;

	@Autowired
	public void setService(M09_Service service) {
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
	@GetMapping("/{id}/com-haken-edit")
	public String init(@PathVariable("id") String id, Model model, Locale locale) {
		model.addAttribute(ControllerConstant.M09_MODEL, M09_HakenCreateModel.builder().build());
		return ControllerConstant.M09_HAKEN_EDIT;
	}

	/**
	 * Edits the.
	 *
	 * @param id            the id
	 * @param hakenModel    the haken model
	 * @param model         the model
	 * @param bindingResult the binding result
	 * @param locale        the locale
	 * @return String
	 */
	@PostMapping("/{id}/com-haken-edit")
	public String edit(@PathVariable("id") String id, @Valid @ModelAttribute M09_HakenCreateModel hakenModel,
			Model model, BindingResult bindingResult, Locale locale) {
		service.save(hakenModel);
		return ControllerConstant.M09_HAKEN_EDIT;
	}
}