/**
 * 
 */
package com.gfi.chequera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gfi.chequera.model.BancosModel;
import com.gfi.chequera.service.IBancosService;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 04/04/2018
 */
@Controller
@RequestMapping("/bancos")
public class BancoCRUDController {
	
	@Autowired
	@Qualifier("BancosService")
	private IBancosService bancoService;
	
	@PostMapping("/insert")
	public String nuevoBanco(@ModelAttribute(name="banco") BancosModel bancoModel) {
		bancoService.saveBanco(bancoModel);
		return "";
	}
	@GetMapping("/listar")
	public ModelAndView listarBancos() {
		return null;
	}
}
