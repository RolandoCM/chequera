/**
 * 
 */
package com.gfi.chequera.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gfi.chequera.entity.Chequera;
import com.gfi.chequera.entity.Movimientos;
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
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); //formato para fecha
		
		movimiento.setIdMovimientos(movimientoModel.getIdMovimiento());
		movimiento.setmConcepto(movimientoModel.getmConcepto());
		movimiento.setmFecha(LocalDateTime.parse(movimientoModel.getmFecha(),formatter));
		movimiento.setmMonto(movimientoModel.getmMonto());
		movimiento.setmStatus(movimientoModel.getmStatus());
		movimiento.setChequera(chequera);
		return movimiento;
	}

	/* Converter movimientos entity to model */
	public MovimientosModel movimientosToModel(Movimientos movimiento) {
		MovimientosModel movimientoModel = new MovimientosModel();
		ChequeraModel chequeraModel = chequeraConverter.ChequeraToModel(movimiento.getChequera());
		Tipo_MovimientosModel tipoMovimientoModel = tipoMovimientoConverter
				.tipoMovimientoToModel(movimiento.getTipoMovimiento());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); //formato para fecha

		movimientoModel.setIdMovimiento(movimiento.getIdMovimientos());
		movimientoModel.setmConcepto(movimiento.getmConcepto());
		movimientoModel.setmFecha(movimiento.getmFecha().format(formatter));
		movimientoModel.setmMonto(movimiento.getmMonto());
		movimientoModel.setmStatus(movimiento.getmStatus());
		movimientoModel.setChequera(chequeraModel);
		movimientoModel.setTipoMovimiento(tipoMovimientoModel);
		return movimientoModel;
	}
}
