package com.gfi.chequera;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

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
	@Test
	public void testCalculaCuenta() {
		CalcularDatosUnicosCuenta c = new CalcularDatosUnicosCuenta();
		assertNotNull(c.calculaNumeroCuenta(22, 340));
	}

}
