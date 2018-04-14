/**
 * 
 */
package com.gfi.chequera.converter;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.gfi.chequera.entity.Movimientos;
import com.gfi.chequera.model.EstadoChequera;

/**
 * @author rolando
 *
 */
@Component
public class EstadoChequeraConverter {
	
	public EstadoChequera movimientosToEstadoChequera(Movimientos movimiento) {
		EstadoChequera estadoChequera = new EstadoChequera();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); //formato para fecha
		estadoChequera.setConcepto(movimiento.getmConcepto());
		estadoChequera.setFecha(movimiento.getmFecha().format(formatter));
		estadoChequera.setTipoMovimiento(movimiento.getTipoMovimiento().getTmDescripcion());
		estadoChequera.setMonto(movimiento.getmMonto());
		
		return estadoChequera;
	}

}
