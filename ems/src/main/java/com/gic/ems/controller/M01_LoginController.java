package com.gic.ems.controller;

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
public class M01_LoginController extends BaseController {

	/**
	 * Login.
	 *
	 * @param model the model
	 * @return String
	 */
	@GetMapping("/login")
	public String login(Model model) {
		return ControllerConstant.M01_LOGIN;
	}

	/**
	 * Access denied.
	 *
	 * @param model the model
	 * @return String
	 */
	@GetMapping("/access-denied")
	public String accessDenied(Model model) {
		return ControllerConstant.ACCESS_DENIED;
	}

	/**
	 * Logout.
	 *
	 * @param model the model
	 * @return String
	 */
	@GetMapping("/logout")
	public String logout(Model model) {
		return ControllerConstant.M01_LOGIN;
	}
}