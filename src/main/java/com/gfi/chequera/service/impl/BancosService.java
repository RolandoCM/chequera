/**
 * 
 */
package com.gfi.chequera.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfi.chequera.converter.BancosConverter;
import com.gfi.chequera.entity.Bancos;
import com.gfi.chequera.model.BancosModel;
import com.gfi.chequera.repository.BancosRepository;
import com.gfi.chequera.service.IBancosService;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 04/04/2018
 */
@Service("BancosService")
public class BancosService implements IBancosService {
	private static final Logger LOG = Logger.getLogger(BancosService.class);
	@Autowired
	private BancosConverter bancoConverter;
	@Autowired
	private BancosRepository bancoRepository;
	@Override
	public void saveBanco(BancosModel bancoModel) {
		Bancos banco = bancoConverter.bancosToEntity(bancoModel);
		banco.setbStatus(true);
		bancoRepository.save(banco);
	}
	@Override
	public List<BancosModel> listBancos() {
		List<Bancos> bancos = bancoRepository.findAll();
		List<BancosModel> bancoModel = new ArrayList<>();
		for(Bancos banco : bancos)
			bancoModel.add(bancoConverter.bancosToModel(banco));
		return bancoModel;
	}
	@Override
	public boolean deleteBanco(int idBanco) {
		Bancos banco = bancoRepository.findByIdBancos(idBanco);
		banco.setbStatus(false);
		bancoRepository.save(banco);
		return false;
	}
	@Override
	public BancosModel searchBanco(int idBanco) {
		Bancos banco =bancoRepository.findByIdBancos(idBanco);
		
		return bancoConverter.bancosToModel(banco);
	}
	@Override
	public void deleteAllBancos() {
		bancoRepository.deleteAll();
	}
	@Override
	public void carga(List<BancosModel> bancosModel) {
		List<Bancos> bancos = new ArrayList<>();
		for(BancosModel bancoModel : bancosModel) {
			Bancos banco = bancoConverter.bancosToEntity(bancoModel);
			bancos.add(banco);
		}
		bancoRepository.save(bancos);
		LOG.info("Lista de entidades banco guardada satisfactoriamente");
	}
}
