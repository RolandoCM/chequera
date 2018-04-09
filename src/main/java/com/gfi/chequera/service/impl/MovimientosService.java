/**
 * 
 */
package com.gfi.chequera.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfi.chequera.converter.ChequeraConverter;
import com.gfi.chequera.converter.MovimientosConverter;
import com.gfi.chequera.entity.Chequera;
import com.gfi.chequera.entity.Movimientos;
import com.gfi.chequera.model.ChequeraModel;
import com.gfi.chequera.model.MovimientosModel;
import com.gfi.chequera.repository.ChequeraRepository;
import com.gfi.chequera.repository.MovimientosRepository;
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
		Chequera chequera = chequeraRepository.findByIdChequera(movimientoModel.getIdChequera());
		
		float saldo = Float.parseFloat(chequera.getChSaldo());
		float monto = movimientoModel.getmMonto();
		saldo = monto+saldo;
		chequera.setChSaldo(String.valueOf(saldo));
		float deposito = Float.parseFloat(chequera.getChAbonos())+monto;
		chequera.setChAbonos(String.valueOf(deposito));
		chequeraRepository.save(chequera);
		Movimientos movimiento = movimientoConverter.movimientosToEntity(movimientoModel);
		movimientoRepository.save(movimiento);
		return false;
	}

	@Override
	public boolean retiro(MovimientosModel movimientoModel) {
		Chequera chequera = chequeraRepository.findByIdChequera(movimientoModel.getIdChequera());
	
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

}
