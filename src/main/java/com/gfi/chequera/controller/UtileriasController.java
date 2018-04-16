/**
 * 
 */
package com.gfi.chequera.controller;


import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.gfi.chequera.service.IUtileriasService;
import com.gfi.chequera.utils.ConstantView;
/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 
 *
 */
@Controller
@RequestMapping("/utilerias")
public class UtileriasController {
	
	private final static Logger LOG = Logger.getLogger(UtileriasController.class);
	@Autowired
	private IUtileriasService utileriasService;
	@GetMapping("")
	public String utilerias() {
		return ConstantView.UTILERIAS;
	}
	@PostMapping("/cargaBancos")
	public String cargaBancos(@RequestParam("file") MultipartFile file) {
		LOG.info("file - - >" +file.getName()+ " tipo - - - 4>"+file.getContentType());
		
		try {
			InputStream input = file.getInputStream();
			utileriasService.cargarBancos(input);
		} catch (IOException e) {
			LOG.error("Ocurrio un error en la lectura del archivo");
			e.printStackTrace();
		}		
		return ConstantView.UTILERIAS;
	}
	@GetMapping("/limpiarBancos")
	public String limpiarBancos() {
		utileriasService.limpiarBancos();
		return "redirect:/utilerias";
	}
	@GetMapping("/limpiarClientes")
	public String limpiarClientes() {
		utileriasService.limpiarClientes();
		return "redirect:/utilerias";
	}
	@GetMapping("/limpiarMovimientos")
	public String limpiarMovimientos() {
		utileriasService.limpiarMovimientos();;
		return "redirect:/utilerias";
	}
	@GetMapping("/limpiarChequeras")
	public String limpiarChequeras() {
		utileriasService.limpiarChequeras();
		return "redirect:/utilerias";
	}
	@PostMapping("/cargaClientes")
	public String cargaClientes(@RequestParam("file") MultipartFile file) {
		LOG.info("file - - >" +file.getName()+ " tipo - - - 4>"+file.getContentType());
		try {
			InputStream input = file.getInputStream();
			utileriasService.cargaClientes(input);
		} catch (IOException e) {
			LOG.error("Ocurrio un error en la lectura del archivo");
			e.printStackTrace();
		}	
		return "redirect:/utilerias";
	}
}
