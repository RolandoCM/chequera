/**
 * 
 */
package com.gfi.chequera.converter;

import org.springframework.stereotype.Component;

import com.gfi.chequera.entity.Clientes;
import com.gfi.chequera.model.ClientesModel;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 05/04/2018
 */
@Component("ClientesConverter")
public class ClientesConverter {
	/*Convertir cliente entity to cliente model*/
	public Clientes clientesToEntity(ClientesModel clienteModel) {
		Clientes cliente = new Clientes();
		cliente.setIdCliente(clienteModel.getIdCliente());
		cliente.setcNombre(clienteModel.getcNombre());
		cliente.setcDireccion(clienteModel.getcDireccion());
		cliente.setcCorreo(clienteModel.getcCorreo());
		cliente.setcRfc(clienteModel.getcRfc());
		cliente.setcStatus(clienteModel.iscStatus());
		cliente.setcRazon(clienteModel.getcRazon());
		return cliente;
	}
	/*Converter cliente model to cliente entity*/
	public ClientesModel clientesToModel(Clientes cliente) {
		ClientesModel clienteModel = new ClientesModel();
		clienteModel.setIdCliente(cliente.getIdCliente());
		clienteModel.setcNombre(cliente.getcNombre());
		clienteModel.setcDireccion(cliente.getcDireccion());
		clienteModel.setcCorreo(cliente.getcCorreo());
		clienteModel.setcRazon(cliente.getcRazon());
		clienteModel.setcRfc(cliente.getcRfc());
		clienteModel.setcStatus(cliente.iscStatus());
		return clienteModel;
	}

}
