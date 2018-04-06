/**
 * 
 */
package com.gfi.chequera.converter;

import org.springframework.stereotype.Component;

import com.gfi.chequera.entity.Bancos;
import com.gfi.chequera.model.BancosModel;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 04/04/2018
 */
@Component("BancosConverter")
public class BancosConverter {
	/*Converter bancos entity to bancos model*/
	public BancosModel bancosToModel (Bancos banco) {
		
		BancosModel bancoModel = new BancosModel();
		bancoModel.setIdBancos(banco.getIdBancos());
		bancoModel.setbNombre(banco.getbNombre());
		bancoModel.setbDireccion(banco.getbDireccion());
		bancoModel.setbSucursal(banco.getbSucursal());
		bancoModel.setbTelefono(banco.getbTelefono());
		bancoModel.setbStatus(banco.isbStatus());
		return bancoModel;
	}
	/*Converter bancos model to bancos entity*/
	public Bancos bancosToEntity (BancosModel bancoModel) {
		Bancos banco = new Bancos();
		banco.setbNombre(bancoModel.getbNombre());
		banco.setbDireccion(bancoModel.getbDireccion());
		banco.setbSucursal(bancoModel.getbTelefono());
		banco.setbStatus(bancoModel.isbStatus());
		return banco;
	}

}
