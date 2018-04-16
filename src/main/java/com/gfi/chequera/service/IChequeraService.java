package com.gfi.chequera.service;

import java.util.List;

import com.gfi.chequera.model.ChequeraModel;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 05/04/2018
 */
public interface IChequeraService {
	public List<ChequeraModel> listChequeras();
	public void saveChequera(ChequeraModel chequeraModel);
	public boolean deleteChequera(int idChequera);
	public ChequeraModel seachChequera(int idChequera);
	public void deleteAllChequera();
}
