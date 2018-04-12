/**
 * 
 */
package com.gfi.chequera.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfi.chequera.service.IUtileriasService;

/**
 * @author rolando
 *
 */
@Service
public class UtileriasService implements IUtileriasService{
	private final static Logger LOG = Logger.getLogger(UtileriasService.class);
	@Autowired
	private ChequeraService chequeraService;
	@Autowired
	private BancosService bancosService;
	@Autowired
	private ClientesService clientesService;
	@Override
	public void limpiarBancos() {
		bancosService.deleteAllBancos();
		LOG.info("Se ha limpiado correctamente la tabla banco");
		
	}
	@Override
	public void limpiarClientes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void limpiarChequeras() {
		// TODO Auto-generated method stub
		
	}
	
}
