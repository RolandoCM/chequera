/**
 * 
 */
package com.gfi.chequera.service;

import java.util.Map;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 11/04/2018
 */
public interface IEstadoChequeraService {
	public abstract Map<String, Object> estadoCuentaMes(int idChequera, String fechaInicio, String fechaCorte);
}
