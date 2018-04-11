/**
 * 
 */
package com.gfi.chequera.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.gfi.chequera.service.impl.EstadoChequeraService;
import com.gfi.chequera.service.impl.MovimientosService;

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
	
	
	
	@GetMapping("/estadochequera")
	public ModelAndView estadoChequera(@RequestParam(name="idChequera", required=true)int idChequera, @RequestParam(name="mes", required=true) String mes) {
		JasperReportsPdfView ecView = new JasperReportsPdfView();
		Map<String, Object> params = new HashMap<>();
		ecView.setUrl("classpath:reports/estadoChequera.jrxml");
		ecView.setApplicationContext(appContext);
		params = estadoChequeraService.estadoCuentaMes(idChequera, mes);
		
		ModelAndView mav = new ModelAndView(ecView, params);	
		return mav;
	}
}
