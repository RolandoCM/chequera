/**
 * 
 */
package com.gfi.chequera.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gfi.chequera.entity.Chequera;
import com.gfi.chequera.model.BancosModel;
import com.gfi.chequera.model.ChequeraModel;
import com.gfi.chequera.model.ClientesModel;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 05/04/2018
 */
@Component("ChequeraConverter")
public class ChequeraConverter {
	@Autowired
	BancosConverter bancosConverter;
	@Autowired
	ClientesConverter clientesConverter;
	
	/*Converter Chequera entity to Chequera model*/
	public ChequeraModel ChequeraToModel (Chequera chequera) {
		ChequeraModel chequeraModel = new ChequeraModel();
		BancosModel bancoModel = bancosConverter.bancosToModel(chequera.getBanco());
		ClientesModel clienteModel = clientesConverter.clientesToModel(chequera.getCliente());
		
		
		chequeraModel.setIdChequera(chequera.getIdChequera());
		chequeraModel.setChClaveInterbancaria(chequera.getChClaveInterbancaria());
		chequeraModel.setChFecha(chequera.getChFecha());
		chequeraModel.setChNumCuenta(chequera.getChNumCuenta());
		chequeraModel.setChSaldo(chequera.getChSaldo());
		chequeraModel.setChFechaCorte(chequera.getChFechaCorte());
		chequeraModel.setChAbonos(chequera.getChAbonos());
		chequeraModel.setChCargos(chequera.getChCargos());
		chequeraModel.setBanco(bancoModel);
		chequeraModel.setChStatus(chequera.isChStatus());
		chequeraModel.setCliente(clienteModel);
		
		return chequeraModel;
	}
	/*Converter Chequera model to Chequera entity*/
	public Chequera ChequeraToEntity() {
		
	}
}
