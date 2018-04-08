/**
 * 
 */
package com.gfi.chequera.exceptions;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gfi.chequera.controller.BancoController;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 06/04/2018
 */
//@ControllerAdvice
public class ExceptionChequera {
	private static final Logger logger = Logger.getLogger(BancoController.class);
	@ExceptionHandler(Exception.class)
	public String exceptionHandler() {
		logger.error("Se encontro un error");
		
		return "404";
	}
}
