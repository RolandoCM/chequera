/**
 * 
 */
package com.gfi.chequera.service.impl;

import java.util.ArrayList;
import java.util.List;

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
	@Autowired
	private BancosConverter bancoConverter;
	@Autowired
	private BancosRepository bancoRepository;
	@Override
	public void saveBanco(BancosModel bancoModel) {
		Bancos banco = bancoConverter.bancosToEntity(bancoModel);
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
	public void updateBanco(BancosModel bancoModel) {
		bancoModel.getIdBancos();
	}
	@Override
	public boolean deleteBanco(int idBanco) {
		
		return false;
	}
}
