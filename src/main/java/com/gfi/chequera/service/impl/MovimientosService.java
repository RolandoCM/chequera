/**
 * 
 */
package com.gfi.chequera.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfi.chequera.converter.ChequeraConverter;
import com.gfi.chequera.converter.EstadoChequeraConverter;
import com.gfi.chequera.converter.MovimientosConverter;
import com.gfi.chequera.entity.Chequera;
import com.gfi.chequera.entity.Movimientos;
import com.gfi.chequera.entity.Tipo_Movimiento;
import com.gfi.chequera.model.ChequeraModel;
import com.gfi.chequera.model.EstadoChequera;
import com.gfi.chequera.model.MovimientosModel;
import com.gfi.chequera.repository.ChequeraRepository;
import com.gfi.chequera.repository.MovimientosRepository;
import com.gfi.chequera.repository.TipoMovimientoRepository;
import com.gfi.chequera.service.IMovimientosService;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 05/04/2018
 */
@Service("MovimientosService")
public class MovimientosService implements IMovimientosService{
	@Autowired
	private ChequeraRepository chequeraRepository;
	@Autowired 
	private ChequeraConverter chequeraConverter;
	@Autowired
	private MovimientosRepository movimientoRepository;
	@Autowired
	private MovimientosConverter movimientoConverter;
	@Autowired
	private TipoMovimientoRepository tipoMovimientoRepository;
	@Autowired 
	private EstadoChequeraConverter estadoChequeraConverter;
	
	private final static Logger LOG = Logger.getLogger(MovimientosService.class);
	@Override
	public List<ChequeraModel> listaCheuqeras() {
		List<Chequera> chequeras = chequeraRepository.findAll();
		List<ChequeraModel> chequerasModel = new ArrayList<>();
		for(Chequera chequera : chequeras)
			chequerasModel.add(chequeraConverter.ChequeraToModel(chequera));
		return chequerasModel;
	}

	@Override
	public boolean deposito(MovimientosModel movimientoModel) {
		Chequera chequera = chequeraRepository.findByIdChequera(movimientoModel.getIdChequera()); //buscar chequera
		Tipo_Movimiento tipoMovimiento = tipoMovimientoRepository.findByIdTipoMovimiento(movimientoModel.getIdTipoMovimiento());
		ChequeraModel chequeraModel = new ChequeraModel();
		/*modificado el saldo*/
		float saldo = Float.parseFloat(chequera.getChSaldo());
		float monto = movimientoModel.getmMonto();
		saldo = monto+saldo;
		chequera.setChSaldo(String.valueOf(saldo));
		float deposito = Float.parseFloat(chequera.getChAbonos())+monto;
		chequera.setChAbonos(String.valueOf(deposito));
		/*Modificado el saldo*/
		
		chequeraRepository.save(chequera);
		chequeraModel = chequeraConverter.ChequeraToModel(chequera);
		movimientoModel.setChequera(chequeraModel);
		Movimientos movimiento = movimientoConverter.movimientosToEntity(movimientoModel);
		
		

		movimiento.setTipoMovimiento(tipoMovimiento);
		movimiento.setmStatus("true");
		movimientoRepository.save(movimiento);
		
		return false;
	}

	@Override
	public boolean retiro(MovimientosModel movimientoModel) {
		Chequera chequera = chequeraRepository.findByIdChequera(movimientoModel.getIdChequera());
		Tipo_Movimiento tipoMovimiento = tipoMovimientoRepository.findByIdTipoMovimiento(movimientoModel.getIdTipoMovimiento());
		Movimientos movimiento = new Movimientos();
		ChequeraModel chequeraModel = new ChequeraModel();
	
		float saldo = Float.parseFloat(chequera.getChSaldo());
		float monto = movimientoModel.getmMonto();
		if(movimientoModel.getmMonto()<=saldo) {
			saldo = saldo-monto;
			monto = Float.parseFloat(chequera.getChCargos())+monto; //retiros
		}
		else {
			saldo = saldo-monto;
			monto = Float.parseFloat(chequera.getChCargos())+monto+(monto*15/100); //retiros
		}
		chequera.setChSaldo(String.valueOf(saldo));
		chequera.setChCargos(String.valueOf(monto));
		/*prepara para guardar*/
		chequeraModel = chequeraConverter.ChequeraToModel(chequera);
		movimientoModel.setChequera(chequeraModel);
		LOG.info("save ----->"+movimientoModel.toString());
		//movimiento.setTipoMovimiento(tipoMovimiento);
		movimiento = movimientoConverter.movimientosToEntity(movimientoModel);
		movimiento.setTipoMovimiento(tipoMovimiento);
		movimiento.setmStatus("true");
		movimientoRepository.save(movimiento);
		return false;
	}

	@Override
	public boolean validarRetiro(MovimientosModel movimientoModel) {
		Chequera chequera = chequeraRepository.findByIdChequera(movimientoModel.getIdChequera());
		boolean saldoSuficiente = false;
		float saldo = Float.parseFloat(chequera.getChSaldo());
		if(movimientoModel.getmMonto()<=saldo)
			saldoSuficiente=true;
		else
			saldoSuficiente=false;
		return saldoSuficiente;
	}

	@Override
	public List<MovimientosModel> listarMovimientos() {
		List<Movimientos> movimientos = movimientoRepository.findAll();
		List<MovimientosModel> movimientosModel = new ArrayList<>();
		for(Movimientos movimiento : movimientos)
			movimientosModel.add(movimientoConverter.movimientosToModel(movimiento));
		return movimientosModel;
	}

	@Override
	public void tipoMovimiento(MovimientosModel movimientoModel) {
		int tipo = movimientoModel.getIdTipoMovimiento();
		if(tipo==1) //cargo
			retiro(movimientoModel);
		else if(tipo==2) //abono
			deposito(movimientoModel);
		else
			LOG.info("otro");
			
	}

	/* Optener los movimientos que se realizaron sobre una chequera en un mes*/
	@Override
	public List<EstadoChequera> estadoChequera(String fechaInicio, String fechaCorte, int idChequera) {
		List<EstadoChequera> estadoChequera = new ArrayList<>();
		Chequera chequera = chequeraRepository.findByIdChequera(idChequera);
		fechaInicio = fechaInicio + " 00:00:00";
		fechaCorte = fechaCorte+ " 23:59:59";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); //formato para fecha
		LocalDateTime fechaInicioD = LocalDateTime.parse(fechaInicio, formatter);
		LocalDateTime fechaCorteD = LocalDateTime.parse(fechaCorte, formatter);
		List<Movimientos> movimientos = movimientoRepository.findByMFechaAfterAndMFechaBeforeAndChequeraEquals(fechaInicioD, fechaCorteD, chequera);
		LOG.info("Size movimientos entity ---------->"+movimientos.size());
		for(Movimientos movimiento : movimientos) {
			estadoChequera.add(estadoChequeraConverter.movimientosToEstadoChequera(movimiento));
		}
		return estadoChequera;
	}

}
