/*
   * 作成日 : 2019/01/26
   * 作成者 : テッ　テッ　カイン
   * 画面名 : M07_個人情報登録画面
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
import com.gic.ems.service.M07_Service;
import com.gic.ems.web.model.M07_EmpInfoCreateModel;

@Controller
public class M07_EmpInfoCreateController {

	@Autowired
	private M07_Service empInfoService;
	
	@GetMapping(value = "/MG07")
	public String hakenCreate(Model model) {
		return "M07-emp-info-create";
	}
	
	@PostMapping("/createEmpInfo")
	public String createEmpInfo(@Valid @ModelAttribute M07_EmpInfoCreateModel empInfoModel,
			BindingResult bindingResult, Model model) {

		empInfoService.save(empInfoModel);
		return ControllerConstant.M07_EMP_INFO_CREATE;
	}
}