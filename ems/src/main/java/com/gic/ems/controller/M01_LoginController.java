package com.gic.ems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class M01_LoginController {

	@GetMapping("/login")
	public String login(Model model) {
		return "M01-login";
	}

	@GetMapping("/accessDenied")
	public String accessDenied(Model model) {
		return "accessDenied";
	}

	@GetMapping("/logout")
	public String logout(Model model) {
		return "M01-login";
	}
}