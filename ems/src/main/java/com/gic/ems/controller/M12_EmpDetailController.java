package com.gic.ems.controller;

import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gic.ems.common.constant.ControllerConstant;
import com.gic.ems.entity.Employee;
import com.gic.ems.service.M12_Service;

@Controller
public class M12_EmpDetailController {

	/** The service. */
	private M12_Service service;

	/** The message source. */
	private MessageSource messageSource;

	/**
	 * Gets the service.
	 *
	 * @return the service
	 */
	@Autowired
	public M12_Service getService() {
		return service;
	}

	/**
	 * Gets the message source.
	 *
	 * @return the message source
	 */
	@Autowired
	public MessageSource getMessageSource() {
		return messageSource;
	}

	/**
	 * Inits the.
	 *
	 * @param id     the id
	 * @param model  the model
	 * @param locale the locale
	 * @return String
	 */
	@GetMapping("/{id}/emp-detail")
	public String init(@PathVariable("id") String id, Model model, Locale locale) {
		String msg12 = messageSource.getMessage("msg12", null, null);
		model.addAttribute("message", msg12);
		Optional<Employee> emp_info = service.findById((long) 1);
		System.out.println("emp info....  " + emp_info);
		model.addAttribute("m012Model", emp_info);
		return ControllerConstant.M12_EMPLOYEE_DETAIL_INFO;
	}
}