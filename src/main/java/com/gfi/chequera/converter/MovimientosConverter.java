/**
 * 
 */
package com.gfi.chequera.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gfi.chequera.entity.Chequera;
import com.gfi.chequera.entity.Movimientos;
import com.gfi.chequera.entity.Tipo_Movimiento;
import com.gfi.chequera.model.ChequeraModel;
import com.gfi.chequera.model.MovimientosModel;
import com.gfi.chequera.model.Tipo_MovimientosModel;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 05/04/2018
 */
@Component("MovimientosConverter")
public class MovimientosConverter {
	@Autowired
	private ChequeraConverter chequeraConverter;
	@Autowired
	private TipoMovimientoConverter tipoMovimientoConverter;

	/* Converter movimientos model to entiry */
	public Movimientos movimientosToEntity(MovimientosModel movimientoModel) {
		Movimientos movimiento = new Movimientos();
		
		Chequera chequera = chequeraConverter.ChequeraToEntity(movimientoModel.getChequera());
		Tipo_Movimiento tipoMovimiento = tipoMovimientoConverter.tipoMovimientoToEntity(movimientoModel.getTipoMovimiento());
		
		movimiento.setmConcepto(movimientoModel.getmConcepto());
		movimiento.setmFecha(movimientoModel.getmFecha());
		movimiento.setmMonto(movimientoModel.getmMonto());
		movimiento.setmStatus(movimientoModel.getmStatus());
		movimiento.setChequera(chequera);
		movimiento.setTipoMovimiento(tipoMovimiento);
		return movimiento;
	}

	/* Converter movimientos entity to model */
	public MovimientosModel movimientosToModel(Movimientos movimiento) {
		MovimientosModel movimientoModel = new MovimientosModel();
		ChequeraModel chequeraModel = chequeraConverter.ChequeraToModel(movimiento.getChequera());
		Tipo_MovimientosModel tipoMovimientoModel = tipoMovimientoConverter
				.tipoMovimientoToModel(movimiento.getTipoMovimiento());

		movimientoModel.setIdMovimiento(movimiento.getIdMovimientos());
		movimientoModel.setmConcepto(movimiento.getmConcepto());
		movimientoModel.setmFecha(movimiento.getmFecha());
		movimientoModel.setmMonto(movimiento.getmMonto());
		movimientoModel.setmStatus(movimiento.getmStatus());
		movimientoModel.setChequera(chequeraModel);
		movimientoModel.setTipoMovimiento(tipoMovimientoModel);
		return movimientoModel;
	}
}
