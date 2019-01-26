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
	@Autowired(required=false)
	M12_Service service;

	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("{id}/emp-detail")
	public String init(@PathVariable Long id, Model model) {
		String msg12 = messageSource.getMessage("msg12", null, Locale.JAPAN);
		model.addAttribute("message", msg12);
		Optional<Employee> emp_info = service.findById((long) 1);
		System.out.println("emp info....  " + emp_info);
		model.addAttribute("m012Model", emp_info);
		return ControllerConstant.M12_EMPLOYEE_DETAIL_INFO;
	}
}