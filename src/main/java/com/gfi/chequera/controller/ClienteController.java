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

import com.gfi.chequera.model.ClientesModel;
import com.gfi.chequera.service.IClientesService;
import com.gfi.chequera.utils.ConstantView;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 07/04/2018
 */

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	private IClientesService clienteService;
	
	private static final Logger LOG = Logger.getLogger(ClienteController.class);
	
	@GetMapping("/listar")
	public ModelAndView listClientes() {
		ModelAndView mav = new ModelAndView(ConstantView.LISTA_CLIENTES);
		List<ClientesModel> clientes = clienteService.listClientes();
		mav.addObject("clientes", clientes);
		return mav;
	}
	@RequestMapping("/delete")
	public String deleteCliente(@RequestParam(name="idCliente", required=true) int idCliente) {
		clienteService.deleteCliente(idCliente);
		return "redirect:/cliente/listar";
	}
	@PostMapping("/add")
	public String addCliente(@ModelAttribute(name="cliente") ClientesModel clienteModel) {
		clienteService.saveCliente(clienteModel);
		LOG.info(clienteModel.toString());
		return "redirect:/cliente/listar";
	}
	@GetMapping("/form")
	public ModelAndView formCliente() {
		ModelAndView mav = new ModelAndView(ConstantView.FORM_CLIENTE);
		ClientesModel cliente = new ClientesModel();
		mav.addObject("cliente", cliente);
		return mav;
	}
	@GetMapping("/formupdate")
	public ModelAndView formUpdate(@RequestParam(name="idCliente", required=true) int idCliente) {
		ModelAndView mav = new ModelAndView(ConstantView.FORM_CLIENTE);
		ClientesModel cliente = clienteService.searchCliente(idCliente);
		mav.addObject("cliente", cliente);
		return mav;
	}
}
