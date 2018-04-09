/**
 * 
 */
package com.gfi.chequera.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gfi.chequera.entity.Bancos;
import com.gfi.chequera.entity.Chequera;
import com.gfi.chequera.entity.Clientes;
import com.gfi.chequera.exceptions.ExceptionConverter;
import com.gfi.chequera.model.BancosModel;
import com.gfi.chequera.model.ChequeraModel;
import com.gfi.chequera.model.ClientesModel;
import com.gfi.chequera.repository.BancosRepository;
import com.gfi.chequera.repository.ClientesRepository;

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
	@Autowired
	BancosRepository bancoRepository;
	@Autowired
	ClientesRepository clienteRepository;
	
	/*Converter Chequera entity to Chequera model*/
	@ExceptionHandler(ExceptionConverter.class)
	public ChequeraModel ChequeraToModel (Chequera chequera) {
		ChequeraModel chequeraModel = new ChequeraModel();
		BancosModel bancoModel = bancosConverter.bancosToModel(chequera.getBanco());
		ClientesModel clienteModel = clientesConverter.clientesToModel(chequera.getCliente());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); //formato para fecha
		
		chequeraModel.setIdChequera(chequera.getIdChequera());
		chequeraModel.setChClaveInterbancaria(chequera.getChClaveInterbancaria());
		chequeraModel.setChFecha(chequera.getChFecha().format(formatter));
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
	@ExceptionHandler(ExceptionConverter.class)
	public Chequera ChequeraToEntity(ChequeraModel chequeraModel) {
		Chequera chequera = new Chequera();
		Bancos banco = bancoRepository.findByIdBancos(chequeraModel.getIdBanco());
		Clientes cliente = clienteRepository.findByIdCliente(chequeraModel.getIdCliente());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); //formato para fecha
		
		chequera.setIdChequera(chequeraModel.getIdChequera());
		chequera.setChClaveInterbancaria(chequeraModel.getChClaveInterbancaria());
		chequera.setChFecha(LocalDateTime.parse(chequeraModel.getChFecha(), formatter));
		chequera.setChNumCuenta(chequeraModel.getChNumCuenta());
		chequera.setChSaldo(chequeraModel.getChSaldo());
		chequera.setChFechaCorte(chequeraModel.getChFechaCorte());
		chequera.setChAbonos(chequeraModel.getChAbonos());
		chequera.setChCargos(chequeraModel.getChCargos());
		chequera.setBanco(banco);
		chequera.setChStatus(chequeraModel.isChStatus());
		chequera.setCliente(cliente);
		
		return chequera;
	}
}
