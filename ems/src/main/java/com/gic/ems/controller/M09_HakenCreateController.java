/*
   * 作成日 : 2019/01/19
   * 作成者 : テッ　テッ　カイン
   * 画面名 : M09_派遣先情報登録画面
 */

package com.gic.ems.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.gic.ems.common.constant.ControllerConstant;
import com.gic.ems.service.M09_Service;
import com.gic.ems.web.model.M09_HakenCreateModel;

@Controller
public class M09_HakenCreateController {

	@Autowired
	M09_Service service;
	
	@GetMapping(value = "/MG09")
	public String hakenCreate(Model model) {
		return "M09-haken-create";
	}
	
	@PostMapping("/createCompanyHaken")
	public String createCompanyHaken(@Valid @ModelAttribute M09_HakenCreateModel hakenModel,
			BindingResult bindingResult, Model model) {

		
		return ControllerConstant.M09_HAKEN_CREATE;
	}
	
	@PostMapping("/updateCompanyHaken")
	public String updateCompanyHaken(@Valid @ModelAttribute M09_HakenCreateModel hakenModel,
			BindingResult bindingResult, Model model) {

		
		return ControllerConstant.M09_HAKEN_CREATE;
	}
	
}
