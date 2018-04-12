/**
 * 
 */
package com.gfi.chequera.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.gfi.chequera.model.ChequeraModel;
import com.gfi.chequera.service.impl.EstadoChequeraService;
import com.gfi.chequera.service.impl.MovimientosService;
import com.gfi.chequera.utils.ConstantView;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 11/04/2018
 */
@Controller
@RequestMapping("/reporte")
public class EstadoChequeraController {
	@Autowired
	private ApplicationContext appContext;
	@Autowired
	private MovimientosService movimientoService;
	@Autowired
	private EstadoChequeraService estadoChequeraService;
	private final static Logger LOG = Logger.getLogger(EstadoChequeraController.class);

	@GetMapping("/chequeras")
	public ModelAndView listaChequera() {
		ModelAndView mav = new ModelAndView(ConstantView.LISTA_CHEQUERAS_OPERACIONES);
		List<ChequeraModel> chequeras = movimientoService.listaCheuqeras();
		mav.addObject("chequeras", chequeras);
		return mav;
	}

	@GetMapping("/estadochequera")
	public ModelAndView estadoChequera(@RequestParam(name = "idChequera", required = true) int idChequera,
			@RequestParam(name = "fechaInicio", required = true) String fechaInicio,
			@RequestParam(name = "fechaCorte", required = true) String fechaCorte) {
		JasperReportsPdfView ecView = new JasperReportsPdfView();
		Map<String, Object> parameters = new HashMap<>();
		ecView.setUrl("classpath:reports/estadoChequera.jrxml");
		ecView.setApplicationContext(appContext);
		parameters = estadoChequeraService.estadoCuentaMes(idChequera, fechaInicio, fechaCorte);

		ModelAndView mav = new ModelAndView(ecView, parameters);
		LOG.info("Params--------->" + parameters);
		return mav;
	}
	@GetMapping("/form")
	public String formConsulta(@RequestParam(name="idChequera", required=true) int idChequera, Model model) {
		model.addAttribute("idChequera", idChequera);
		return ConstantView.FORM_ESTADO_CUENTA;
	}
}
