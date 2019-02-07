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
import com.gic.ems.service.M02_Service;
import com.gic.ems.web.model.M02_PwdChangeModel;

/**
 * The Class M02_PwdChangeController.
 *
 * @author PhuuKhinKhin Jan 26, 2019 <BR>
 *         The Class M02_PwdChangeController.
 */
@Controller
public class M02_PwdChangeController {

	/** The service. */
	private M02_Service service;

	/**
	 * Sets the service.
	 *
	 * @param service the new service
	 */
	@Autowired
	public void setService(M02_Service service) {
		this.service = service;
	}

	/**
	 * Inits the.
	 *
	 * @param model the model
	 * @return String
	 */
	@GetMapping("/password-change")
	public String init(Model model, Locale locale) {
		model.addAttribute(ControllerConstant.M02_MODEL, M02_PwdChangeModel.builder().build());
		return ControllerConstant.M02_PASSWORD_CHANGE;
	}

	/**
	 * Update.
	 *
	 * @param m02Model the m 02 model
	 * @param model    the model
	 * @param result   the result
	 * @return String
	 */
	@PostMapping("/password-change")
	public String change(@ModelAttribute M02_PwdChangeModel m02Model, Model model, BindingResult bindingResult,
			Locale locale) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("erros", "Error Messages");
		} else {
			this.service.update(m02Model);
		}
		return ControllerConstant.M02_PASSWORD_CHANGE;
	}
}