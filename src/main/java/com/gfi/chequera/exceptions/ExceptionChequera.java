/**
 * 
 */
package com.gfi.chequera.exceptions;

import org.apache.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gfi.chequera.controller.BancoController;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 06/04/2018
 */
@ControllerAdvice
public class ExceptionChequera {
	private static final Logger LOG = Logger.getLogger(BancoController.class);
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e) {
		LOG.error("Se encontro un error", e);
		
		return "404";
	}
	@ExceptionHandler(DataIntegrityViolationException.class)
	public String exceptionIntegrity(Exception e) {
		LOG.warn("Warnning en el acceso a datos");
		return "integrityErr";
	}
}
