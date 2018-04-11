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
import com.gfi.chequera.model.MovimientosModel;
import com.gfi.chequera.service.IMovimientosService;
import com.gfi.chequera.service.ITipoMovimientosService;
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
	private IMovimientosService movimientoService;
	@Autowired
	private ITipoMovimientosService tipoMovimientoService;
	
	private final static Logger LOG = Logger.getLogger(MovimientosController.class);
	@GetMapping("/listar")
	public ModelAndView listaMovimientos() {
		ModelAndView mav = new ModelAndView(ConstantView.ANALISIS_SALDO);
		mav.addObject("movimientos", movimientoService.listarMovimientos());
		return mav;
	}
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
		MovimientosModel movimiento = new MovimientosModel();
		mav.addObject("movimiento",movimiento );
		mav.addObject("tipoMovimientos", tipoMovimientoService.tipoDeMovimientos());
		mav.addObject("idChequera", idChequera);
		return mav;
	}
	@PostMapping("/add")
	public String addMovimiento(@ModelAttribute(name="movimiento") MovimientosModel movimiento) {
		LOG.info("ModelMovimiento ---> "+movimiento.toString());
		movimientoService.tipoMovimiento(movimiento);
		return "redirect:/movimientos/chequeras";
	}
}
