/**
 * 
 */
package com.gfi.chequera.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 07/04/2018
 */

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@GetMapping("/list")
	public ModelAndView listClientes() {
		//TODO
		return null;
	}
	@PostMapping("/insert")
	public String insertCliente() {
		//TODO
		return null;
	}
	@DeleteMapping("/delete")
	public String deleteCliente() {
		//TODO
		return null;
	}
	@PutMapping("/update")
	public String updateCliente() {
		//TODO
		return null;
	}

}
