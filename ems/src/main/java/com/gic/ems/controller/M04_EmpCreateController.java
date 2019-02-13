package com.gic.ems.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.gic.ems.common.constant.ControllerConstant;
import com.gic.ems.common.constant.MessageConstant;
import com.gic.ems.service.M04_Service;
import com.gic.ems.web.model.M04_EmpCreateModel;

/**
 * The Class M04_EmpCreateController.
 *
 * @author MOEPWINTPHYU Jan 26, 2019 <BR>
 *         The Class M04_EmpCreateController.
 */
@Controller
public class M04_EmpCreateController extends BaseController {

	/** The service. */
	private M04_Service service;

	/**
	 * Sets the service.
	 *
	 * @param service the new service
	 */
	@Autowired
	public void setService(M04_Service service) {
		this.service = service;
	}

	/**
	 * @param model
	 * @param locale
	 * @return
	 */
	@GetMapping("/emp-create")
	public String init(Model model) {
		model.addAttribute("m04Model", new M04_EmpCreateModel());
		return ControllerConstant.M04_EMPLOYEE_INTIAL_INFO;
	}

	/**
	 * Creates the employee.
	 *
	 * @param empModel      the emp model
	 * @param bindingResult the binding result
	 * @param model         the model
	 * @return String
	 * @throws Exception
	 */
	@PostMapping("/emp-create")
	public String create(@Valid @ModelAttribute M04_EmpCreateModel empModel, BindingResult bindingResult, Model model,
			RedirectAttributes redirectAttributes) {
		this.service.save(empModel);
		redirectAttributes.getFlashAttributes().clear();
		redirectAttributes.addFlashAttribute(MessageConstant.MESSAGE,
				this.getMessage(MessageConstant.SUCCESSFULLY_SAVE));
		return super.redirectURL(ControllerConstant.EMP_CREATE);
	}
}