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

import lombok.NonNull;

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

	/**
	 * Sets the service.
	 *
	 * @param service the new service
	 */
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
	@GetMapping("/{id}/comp-haken-edit")
	public String init(@PathVariable("id") @NonNull Long id, Model model, Locale locale) {
		model.addAttribute(ControllerConstant.M09_MODEL, this.service.findDispatchDepartment(id));
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
	 * @throws Exception
	 */
	@PostMapping("/{id}/comp-haken-edit")
	public String edit(@PathVariable("id") @NonNull Long id, @Valid @ModelAttribute M09_HakenCreateModel m09Model,
			Model model, BindingResult bindingResult, Locale locale) throws Exception {
		this.service.update(m09Model);
		return ControllerConstant.M09_HAKEN_EDIT;
	}
}