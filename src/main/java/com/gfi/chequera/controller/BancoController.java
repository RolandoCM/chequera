/**
 * 
 */
package com.gfi.chequera.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gfi.chequera.model.BancosModel;
import com.gfi.chequera.service.IBancosService;
import com.gfi.chequera.utils.ConstantView;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 04/04/2018
 */
@Controller
@RequestMapping("/bancos")
public class BancoController {
	
	@Autowired
	@Qualifier("BancosService")
	private IBancosService bancoService;
	
	private static final Logger logger = Logger.getLogger(BancoController.class);
	
	/*@PostMapping("/insert")
	public String nuevoBanco(@ModelAttribute(name="banco") BancosModel bancoModel) {
		bancoService.saveBanco(bancoModel);
		return ConstantView.insertBanco;
	}*/
	@GetMapping("/form")
	public ModelAndView formInsert() {
		ModelAndView mav = new ModelAndView(ConstantView.formBanco);
		mav.addObject("banco", new BancosModel());
		return mav;
	}
	@GetMapping("/listar")
	public ModelAndView listarBancos() {
		ModelAndView mav = new ModelAndView(ConstantView.listaBancos);
		List<BancosModel>bancos = bancoService.listBancos();
		mav.addObject("bancos",bancos);
		logger.info("Se a listado correctamente los bancos");
		return mav;
	}
	/*Update methods */
	@GetMapping("/formupdate")
	public ModelAndView formUpdate(@RequestParam(name="idBanco", required=true) int idBanco) {
		ModelAndView mav = new ModelAndView(ConstantView.formBanco);
		BancosModel bancoModel = bancoService.searchBanco(idBanco);
		mav.addObject("banco", bancoModel);
		return mav;
	}
	@PostMapping("/update")
	public String updateBanco(@ModelAttribute(name="banco") BancosModel bancoModel) {
		bancoService.updateBanco(bancoModel);
		logger.info(bancoModel.toString());
		return ConstantView.updateBanco;
	}
	/*Update methods finish*/
	
	@RequestMapping("/delete")
	public String deleteBanco(@RequestParam(name="idBanco") int idBanco) {
		bancoService.deleteBanco(idBanco);
		return ConstantView.deleteBanco;
	}
}
