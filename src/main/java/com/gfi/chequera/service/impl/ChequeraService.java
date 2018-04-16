/**
 * 
 */
package com.gfi.chequera.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfi.chequera.converter.ChequeraConverter;
import com.gfi.chequera.entity.Chequera;
import com.gfi.chequera.model.ChequeraModel;
import com.gfi.chequera.repository.ChequeraRepository;
import com.gfi.chequera.service.IChequeraService;
import com.gfi.chequera.utils.CalcularDatosUnicosCuenta;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 05/04/2018
 */
@Service("ChequeraService")
public class ChequeraService implements IChequeraService{
	private final static Logger LOG = Logger.getLogger(ChequeraService.class);
	@Autowired
	private ChequeraRepository chequeraRepository;
	@Autowired
	private ChequeraConverter chequeraConverter;
	@Autowired
	private CalcularDatosUnicosCuenta calculaDatosCuenta;
	
	private Chequera chequera;
	private ChequeraModel chequeraModel;
	
	/*Retorna lista de chequeras encontradas en la DB*/
	@Override
	public List<ChequeraModel> listChequeras() {
		List<Chequera> chequeras = chequeraRepository.findAll();
		List<ChequeraModel> chequerasModel = new ArrayList<>();
		for(Chequera chequera : chequeras)
			chequerasModel.add(chequeraConverter.ChequeraToModel(chequera));
		return chequerasModel;
	}
	/*Save and update chequera*/
	@Override
	public void saveChequera(ChequeraModel chequeraModel) {
		/*Calcular numero unico de cuenta y clave intervancaria*/
		String chNumCuenta = calculaDatosCuenta.calculaNumeroCuenta(chequeraModel.getIdBanco(), chequeraModel.getIdCliente());
		chequeraModel.setChNumCuenta(chNumCuenta);
		String chClaveInterbancaria = calculaDatosCuenta.calculaClaveIntervancaria(chNumCuenta);
		chequeraModel.setChClaveInterbancaria(chClaveInterbancaria);
		chequera = chequeraConverter.ChequeraToEntity(chequeraModel);
		chequera.setChAbonos("0");
		chequera.setChCargos("0");
		chequeraRepository.save(chequera);
	}

	/*change the status to false in chequera*/
	@Override
	public boolean deleteChequera(int idChequera) {
		chequera=chequeraRepository.findByIdChequera(idChequera);
		chequera.setChStatus(false);
		chequeraRepository.save(chequera);
		return false;
	}

	/*search specific chequera for id*/
	@Override
	public ChequeraModel seachChequera(int idChequera) {
		chequera = chequeraRepository.findByIdChequera(idChequera);
		chequeraModel = chequeraConverter.ChequeraToModel(chequera);
		return chequeraModel;
	}
	@Override
	public void deleteAllChequera() {
		chequeraRepository.deleteAll();
		LOG.info("Se ha limpiado la tabla de chequeras satisfactoriamente");
	}

}
