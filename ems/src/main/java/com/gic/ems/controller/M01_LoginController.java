package com.gic.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The Class M01_LoginController.
 *
 * @author KYIMINHAN Jan 26, 2019 <BR>
 *         The Class M01_LoginController.
 */
@Controller
public class M01_LoginController {

	/**
	 * Login.
	 *
	 * @param model the model
	 * @return String
	 */
	@GetMapping("/login")
	public String login(Model model) {
		return "M01-login";
	}

	/**
	 * Access denied.
	 *
	 * @param model the model
	 * @return String
	 */
	@GetMapping("/accessDenied")
	public String accessDenied(Model model) {
		return "accessDenied";
	}

	/**
	 * Logout.
	 *
	 * @param model the model
	 * @return String
	 */
	@GetMapping("/logout")
	public String logout(Model model) {
		return "M01-login";
	}
}