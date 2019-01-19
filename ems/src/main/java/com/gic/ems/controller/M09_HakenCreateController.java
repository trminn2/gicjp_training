/*
   * 作成日 : 2019/01/19
   * 作成者 : テッ　テッ　カイン
   * 画面名 : M09_派遣先情報登録画面
 */

package com.gic.ems.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class M09_HakenCreateController {

	@GetMapping(value = "/MG09")
	public String hakenCreate(Model model) {
		return "M09-haken-create";
	}
}
