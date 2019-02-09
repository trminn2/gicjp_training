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
import com.gic.ems.service.M13_Service;
import com.gic.ems.web.model.M13_CustCreateModel;

/**
 * The Class M13_CustCreateController.
 *
 * @author THAEMYATNOELWIN Jan 27, 2019 <BR>
 *         The Class M13_CustCreateController.
 */
@Controller
public class M13_CustCreateController extends BaseController {

	/** The service. */
	private M13_Service service;

	/**
	 * Sets the service.
	 *
	 * @param service the new service
	 */
	@Autowired
	public void setService(M13_Service service) {
		this.service = service;
	}

	/**
	 * Inits the.
	 *
	 * @param model  the model
	 * @param locale the locale
	 * @return String
	 */
	@GetMapping("/cust-create")
	public String init(Model model) {
		model.addAttribute(ControllerConstant.M13_MODEL, M13_CustCreateModel.builder().build());
		return ControllerConstant.M13_CUSTOMER_CREATE;
	}

	/**
	 * Creates the.
	 *
	 * @param customerModel the customer model
	 * @param bindingResult the binding result
	 * @param model         the model
	 * @return String
	 */
	@PostMapping("/cust-create")
	public String create(@Valid @ModelAttribute M13_CustCreateModel m13Model, Model model,
			BindingResult bindingResult) {
		this.service.save(m13Model);
		model.addAttribute(ControllerConstant.MESSAGE,ControllerConstant.SUCCESSFULLY_SAVE);
		return super.redirectURL(ControllerConstant.M13_CUSTOMER_CREATE);
	}
}