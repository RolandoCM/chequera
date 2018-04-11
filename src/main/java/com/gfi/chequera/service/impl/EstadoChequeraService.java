/**
 * 
 */
package com.gfi.chequera.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfi.chequera.converter.MovimientosConverter;
import com.gfi.chequera.model.ChequeraModel;
import com.gfi.chequera.model.EstadoChequera;
import com.gfi.chequera.repository.MovimientosRepository;
import com.gfi.chequera.service.IEstadoChequeraService;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 11/04/2018
 */
@Service
public class EstadoChequeraService implements IEstadoChequeraService{

	@Autowired
	private MovimientosRepository movimientoRepository;
	@Autowired
	private MovimientosConverter movimientoConverter;
	@Autowired
	private MovimientosService movimientoService;
	@Autowired
	private ChequeraService chequeraService;
	@Override
	public Map<String, Object> estadoCuentaMes(int idChequera, String mes) {
		Map<String, Object> params = new HashMap<>();
		ChequeraModel chequeraModel = new ChequeraModel();
		List<EstadoChequera> listMovimientosModel = new ArrayList<>();
		chequeraModel = chequeraService.seachChequera(idChequera);
		//listMovimientosModel = movimientoService.listarMovimientos();
		JRBeanCollectionDataSource movimientosDS = new JRBeanCollectionDataSource(listMovimientosModel);
		
		params.put("banco", chequeraModel.getBanco().getbNombre());
		params.put("chequera", Integer.toString(chequeraModel.getIdChequera()));
		params.put("datasource", movimientosDS);
		return null;
	}

}
