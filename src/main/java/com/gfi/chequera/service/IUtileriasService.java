/**
 * 
 */
package com.gfi.chequera.service;

import java.io.InputStream;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 *
 */
public interface IUtileriasService {
	public abstract void limpiarBancos();
	public abstract void cargarBancos(InputStream input);
	public abstract void limpiarClientes();
	public abstract void limpiarChequeras();
	public abstract void limpiarMovimientos();
	public abstract void cargaClientes(InputStream input);
}
