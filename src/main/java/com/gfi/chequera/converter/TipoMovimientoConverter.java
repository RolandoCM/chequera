/**
 * 
 */
package com.gfi.chequera.converter;

import org.springframework.stereotype.Component;

import com.gfi.chequera.entity.Tipo_Movimiento;
import com.gfi.chequera.model.Tipo_MovimientosModel;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 06/04/2018
 */
@Component("TipoMovimiento")
public class TipoMovimientoConverter {
	
	/*converter tipoMovimiento model to entity*/
	public Tipo_MovimientosModel tipoMovimientoToModel(Tipo_Movimiento tipoMovimiento) {
		Tipo_MovimientosModel tipoMovimientoModel = new Tipo_MovimientosModel();
		
		tipoMovimientoModel.setIdTipoMovimiento(tipoMovimiento.getIdTipoMovimiento());
		tipoMovimientoModel.setTmDescripcion(tipoMovimiento.getTmDescripcion());
		return tipoMovimientoModel;
	}
	/*converter tipoMovimiento entity to model*/
	public Tipo_Movimiento tipoMovimientoToEntity(Tipo_MovimientosModel tipoMovimientoModel) {
		Tipo_Movimiento tipoMovimiento = new Tipo_Movimiento();
		tipoMovimiento.setIdTipoMovimiento(tipoMovimiento.getIdTipoMovimiento());
		tipoMovimiento.setTmDescripcion(tipoMovimientoModel.getTmDescripcion());
		return tipoMovimiento;
	}
}
