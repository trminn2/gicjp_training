package com.gic.ems.controller;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gic.ems.common.constant.ControllerConstant;
import com.gic.ems.common.constant.MessageConstant;
import com.gic.ems.service.M13_Service;
import com.gic.ems.web.model.M13_CustCreateModel;

import lombok.NonNull;

/**
 * The Class M15_CustEditController.
 *
 * @author THAEMYATNOELWIN Jan 26, 2019 <BR>
 *         The Class M13_CustEditController.
 */
@Controller
public class M13_CustEditController extends BaseController{

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
	 * @param id     the id
	 * @param model  the model
	 * @param locale the locale
	 * @return String
	 */
	@GetMapping("/{id}/cust-edit")
	public String init(@PathVariable("id") @NonNull String id, Model model) {
		model.addAttribute(ControllerConstant.M13_MODEL, this.service.findById(Long.valueOf(id)));
		return ControllerConstant.M13_CUSTOMER_EDIT;
	}

	/**
	 * Edits the.
	 *
	 * @param id     the id
	 * @param model  the model
	 * @param locale the locale
	 * @return String
	 */
	@PostMapping("/{id}/cust-edit")
	public String edit(@PathVariable("id") @NonNull String id,@ModelAttribute M13_CustCreateModel m13Model, Model model, RedirectAttributes redirectAttributes) {
		this.service.update(m13Model);
		redirectAttributes.getFlashAttributes().clear();
		redirectAttributes.addFlashAttribute(MessageConstant.MESSAGE,this.getMessage( MessageConstant.SUCCESSFULLY_EDIT));
		return super.redirectURL(id,ControllerConstant.CUST_EDIT);
	}
}