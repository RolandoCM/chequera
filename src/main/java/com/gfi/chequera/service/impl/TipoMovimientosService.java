/**
 * 
 */
package com.gfi.chequera.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfi.chequera.converter.TipoMovimientoConverter;
import com.gfi.chequera.entity.Tipo_Movimiento;
import com.gfi.chequera.model.Tipo_MovimientosModel;
import com.gfi.chequera.repository.TipoMovimientoRepository;
import com.gfi.chequera.service.ITipoMovimientosService;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 09/04/2018
 */
@Service
public class TipoMovimientosService implements ITipoMovimientosService{
	
	@Autowired
	private TipoMovimientoRepository tipoMovimientoRepository;
	@Autowired
	private TipoMovimientoConverter tipoMovimientoConverter;
	@Override
	public List<Tipo_MovimientosModel> tipoDeMovimientos() {
		List<Tipo_Movimiento> tipoMovimientos = tipoMovimientoRepository.findAll();
		List<Tipo_MovimientosModel> tipoMovimientoModel = new ArrayList<>();
		for(Tipo_Movimiento tipo : tipoMovimientos)
			tipoMovimientoModel.add(tipoMovimientoConverter.tipoMovimientoToModel(tipo));
		return tipoMovimientoModel;
	}

}
