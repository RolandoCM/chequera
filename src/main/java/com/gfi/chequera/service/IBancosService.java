/**
 * 
 */
package com.gfi.chequera.service;

import java.util.List;

import com.gfi.chequera.model.BancosModel;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 04/04/2018
 */

public interface IBancosService {
	public void saveBanco(BancosModel bancoModel);
	public List<BancosModel> listBancos();
	public boolean deleteBanco(int idBanco);
	public BancosModel searchBanco(int idBanco);
	public void deleteAllBancos();
}
