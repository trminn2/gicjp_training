package com.gic.ems.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gic.ems.common.constant.ControllerConstant;

@Controller
public class M00_HomeController {

	@GetMapping(value = { "/", "/home" })
	public String home(Model model, Locale locale) {
		return ControllerConstant.HOME;
	}
}