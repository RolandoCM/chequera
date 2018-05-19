/**
 * 
 */
package com.gfi.chequera.utils;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 08/04/2018
 */
@Component
public class CalcularDatosUnicosCuenta {
	private static final  Logger LOG = Logger.getLogger(CalcularDatosUnicosCuenta.class);
	public String calculaNumeroCuenta(int idBanco, int idCliente) {
		StringBuilder noCuenta = new StringBuilder();
		StringBuilder sIdBanco = new StringBuilder();
		sIdBanco.append(idBanco);
		String sIdCliente = String.valueOf(idCliente);
		while(sIdBanco.length()<3)
			sIdBanco.append("0");
		
		while(sIdCliente.length()<3)
			sIdCliente = "0"+sIdCliente;
		int cuenta = (int) (Math.floor(Math.random()*(1000-9999+1)+9999));
		noCuenta.append(sIdBanco);
		noCuenta.append(sIdCliente);
		noCuenta.append(cuenta);
		
		LOG.info("cliente: "+sIdCliente+" Banco: "+sIdBanco+" cuenta: "+noCuenta);
		return noCuenta.toString();
	}
	public String calculaClaveIntervancaria(String numCuenta) {
		StringBuilder claveBancaria = new StringBuilder();
		int clave = (int) (Math.floor(Math.random()*(100000-999999+1)+999999));
		claveBancaria.append(numCuenta);
		claveBancaria.append(clave);
		LOG.info("Clave interbancaria: "+ claveBancaria);
		return claveBancaria.toString();
	}
}
