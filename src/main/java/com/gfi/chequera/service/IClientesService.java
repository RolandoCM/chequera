package com.gfi.chequera.service;

import java.util.List;

import com.gfi.chequera.model.ClientesModel;

/**
 * @author Rolando Castillo
 * @email castillomartinez@acm.org
 * @date 05/04/2018
 */

public interface IClientesService {
	
	public List<ClientesModel> listClientes();
	public void saveCliente(ClientesModel clienteModel);
	public boolean deleteCliente(int idCliente);
	public ClientesModel searchCliente(int idCliente);

}
