/**
 * 
 */
package com.gfi.chequera.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gfi.chequera.model.ChequeraModel;
import com.gfi.chequera.service.IBancosService;
import com.gfi.chequera.service.IChequeraService;
import com.gfi.chequera.utils.ConstantView;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 08/04/2018
 */
@Controller
@RequestMapping("/chequera")
public class ChequeraController {
	@Autowired
	private IChequeraService chequeraService;
	@Autowired
	private IBancosService bancoService;
	
	private final static Logger LOG = Logger.getLogger(ChequeraController.class);
	
	@GetMapping("/listar")
	public ModelAndView listClientes() {
		ModelAndView mav = new ModelAndView(ConstantView.LISTA_CHEQUERAS);
		List<ChequeraModel> chequeras = chequeraService.listChequeras();
		mav.addObject("chequeras", chequeras);
		return mav;
	}
	@RequestMapping("/delete")
	public String deleteCliente(@RequestParam(name="idChequera", required=true) int idChequera) {
		chequeraService.deleteChequera(idChequera);
		return "redirect:/chequera/listar";
	}
	@PostMapping("/add")
	public String addCliente(@ModelAttribute(name="chequera") ChequeraModel chequeraModel) {
		LOG.info(chequeraModel.toString());
		chequeraService.saveChequera(chequeraModel);
		return "redirect:/chequera/listar";
	}
	@GetMapping("/form")
	public ModelAndView formCliente() {
		ModelAndView mav = new ModelAndView(ConstantView.FORM_CHEQUERA);
		ChequeraModel chequera = new ChequeraModel();
		mav.addObject("chequera", chequera);
		mav.addObject("bancos", bancoService.listBancos());
		return mav;
	}
	@GetMapping("/formupdate")
	public ModelAndView formUpdate(@RequestParam(name="idChequera", required=true) int idChequera) {
		ModelAndView mav = new ModelAndView(ConstantView.FORM_CHEQUERA);
		ChequeraModel chequera = chequeraService.seachChequera(idChequera);
		mav.addObject("chequera", chequera);
		return mav;
	}
	
}
