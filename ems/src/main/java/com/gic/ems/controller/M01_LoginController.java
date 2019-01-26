package com.gic.ems.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gic.ems.common.constant.ControllerConstant;

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
	public String login(Model model, Locale locle) {
		return ControllerConstant.M01_LOGIN;
	}

	/**
	 * Access denied.
	 *
	 * @param model the model
	 * @return String
	 */
	@GetMapping("/accessDenied")
	public String accessDenied(Model model, Locale locle) {
		return ControllerConstant.ACCESSDENIED;
	}

	/**
	 * Logout.
	 *
	 * @param model the model
	 * @return String
	 */
	@GetMapping("/logout")
	public String logout(Model model, Locale locle) {
		return ControllerConstant.M01_LOGIN;
	}
}