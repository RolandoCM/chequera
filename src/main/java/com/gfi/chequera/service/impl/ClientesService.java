/**
 * 
 */
package com.gfi.chequera.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfi.chequera.converter.ClientesConverter;
import com.gfi.chequera.entity.Clientes;
import com.gfi.chequera.model.ClientesModel;
import com.gfi.chequera.repository.ClientesRepository;
import com.gfi.chequera.service.IClientesService;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 05/04/2018
 */
@Service("ClientesService")
public class ClientesService implements IClientesService{
	@Autowired
	ClientesConverter clienteConverter;
	@Autowired
	ClientesRepository clienteRepository;
	
	private Clientes cliente;
	private ClientesModel clienteModel;
	
	/*Retorna una lista de todos los clientes encontrados en la base de datos*/
	@Override
	public List<ClientesModel> listClientes() {
		List<Clientes> clientes = clienteRepository.findAll();
		List<ClientesModel> clientesModel = new ArrayList<>();
		for(Clientes cliente : clientes) 
			clientesModel.add(clienteConverter.clientesToModel(cliente));
		return clientesModel;
	}

	@Override
	public void saveCliente(ClientesModel clienteModel) {
		cliente = clienteConverter.clientesToEntity(clienteModel);
		clienteRepository.save(cliente);
	}
	@Override
	public boolean deleteCliente(int idCliente) {
		cliente = clienteRepository.findByIdCliente(idCliente);
		cliente.setcStatus(false);
		clienteRepository.save(cliente);
		return false;
	}

	@Override
	public ClientesModel searchCliente(int idCliente) {
		cliente = clienteRepository.findByIdCliente(idCliente);
		clienteModel = clienteConverter.clientesToModel(cliente);
		return clienteModel;
	}

}
