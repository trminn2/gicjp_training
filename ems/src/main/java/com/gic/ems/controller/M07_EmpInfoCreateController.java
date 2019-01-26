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
import com.gic.ems.service.M07_Service;
import com.gic.ems.web.model.M07_EmpInfoCreateModel;

/**
 * The Class M07_EmpInfoCreateController.
 *
 * @author ThetThetKhine Jan 26, 2019 <BR>
 *         The Class M07_EmpInfoCreateController.
 */
@Controller
public class M07_EmpInfoCreateController {

	/** The service. */
	private M07_Service service;

	/**
	 * Sets the service.
	 *
	 * @param service the new service
	 */
	@Autowired
	public void setService(M07_Service service) {
		this.service = service;
	}

	/**
	 * Haken create.
	 *
	 * @param model  the model
	 * @param locale the locale
	 * @return String
	 */
	@GetMapping("/emp-info-create")
	public String init(Model model, Locale locale) {
		return ControllerConstant.M07_EMP_INFO_CREATE;
	}

	/**
	 * Creates the emp info.
	 *
	 * @param empInfoModel  the emp info model
	 * @param model         the model
	 * @param bindingResult the binding result
	 * @param locale        the locale
	 * @return String
	 */
	@PostMapping("/emp-info-create")
	public String create(@Valid @ModelAttribute M07_EmpInfoCreateModel empInfoModel, Model model,
			BindingResult bindingResult, Locale locale) {
		this.service.save(empInfoModel);
		return ControllerConstant.M07_EMP_INFO_CREATE;
	}
}