package com.gic.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gic.ems.common.constant.ControllerConstant;

/**
 * The Class M00_HomeController.
 *
 * @author KYIMINHAN Jan 27, 2019 <BR>
 *         The Class M00_HomeController.
 */
@Controller
public class M00_HomeController {

	/**
	 * Home.
	 *
	 * @param model  the model
	 * @param locale the locale
	 * @return String
	 */
	@GetMapping(value = { "/", "/home" })
	public String home(Model model) {
		return ControllerConstant.HOME;
	}
}