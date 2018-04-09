/**
 * 
 */
package com.gfi.chequera;

import com.gfi.chequera.utils.CalcularDatosUnicosCuenta;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 08/04/2018
 */
public class PruebaCuenta {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CalcularDatosUnicosCuenta c = new CalcularDatosUnicosCuenta();
		String numCuenta = c.calculaNumeroCuenta(22, 340);
		c.calculaClaveIntervancaria(numCuenta);
	}

}
