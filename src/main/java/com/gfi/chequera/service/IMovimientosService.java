package com.gfi.chequera.service;

import java.util.List;

import com.gfi.chequera.model.ChequeraModel;
import com.gfi.chequera.model.MovimientosModel;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 05/04/2018
 */

public interface IMovimientosService {
	public List<ChequeraModel> listaCheuqeras();
	public boolean deposito(MovimientosModel movimientoModel);
	public boolean retiro(MovimientosModel movimientoModel);
	public boolean validarRetiro(MovimientosModel movimientoModel);
}
