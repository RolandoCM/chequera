/**
 * 
 */
package com.gfi.chequera.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gfi.chequera.model.ChequeraModel;
import com.gfi.chequera.service.impl.MovimientosService;
import com.gfi.chequera.utils.ConstantView;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 08/04/2018
 */
@Controller
@RequestMapping("/movimientos")
public class MovimientosController {
	
	@Autowired
	private MovimientosService movimientoService;
	
	@GetMapping("/chequeras")
	public ModelAndView listaChequera() {
		ModelAndView mav = new ModelAndView(ConstantView.LISTA_CHEQUERAS_MOVIMIENTOS);
		List<ChequeraModel> chequeras = movimientoService.listaCheuqeras();
		mav.addObject("chequeras", chequeras);
		return mav;
	}
	@GetMapping("/form")
	public ModelAndView formMovimiento(@RequestParam(name="idChequera", required=true)int idChequera) {
		ModelAndView mav = new ModelAndView(ConstantView.FORM_MOVIMIENTO);
		
		return mav;
	}
}
